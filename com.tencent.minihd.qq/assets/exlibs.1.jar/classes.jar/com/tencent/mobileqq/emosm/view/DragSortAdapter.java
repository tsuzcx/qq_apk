package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.ProgressButton;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class DragSortAdapter
  extends BaseAdapter
{
  private static final int COMPLETE = 4;
  private static final int DOWN_BTN_DOWNING = 2;
  private static final int DOWN_BTN_IDLE = 3;
  private static final int UPDATE_BTN_DOWNING = 1;
  private static final int UPDATE_BTN_IDLE = 0;
  public static final String VIPOpen = "MyEmosomAdapter";
  Handler handler;
  private LruCache mCache = new LruCache(30);
  protected Context mContext;
  protected List mData;
  private Drawable mDefaultIcon;
  private HashMap mDownListener;
  private boolean mIsEdited;
  private Object mLock = new Object();
  private boolean mNotifyOnChange;
  private HashMap mSelectStatus = new HashMap();
  private HashMap mUpdateListener;
  JSONArray mWordingList;
  private int progressDafaultColor;
  
  public DragSortAdapter(Context paramContext, List paramList)
  {
    this.mContext = paramContext;
    this.mData = paramList;
    this.mDefaultIcon = this.mContext.getResources().getDrawable(2130838006);
    this.mWordingList = ClubContentJsonTask.a((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime());
    this.handler = new Handler();
    this.mUpdateListener = new HashMap();
    this.mDownListener = new HashMap();
    this.progressDafaultColor = this.mContext.getResources().getColor(2131427896);
  }
  
  private void download(EmoticonPackage paramEmoticonPackage, View paramView1, View paramView2)
  {
    paramView1 = (QQAppInterface)((BaseActivity)this.mContext).getAppRuntime();
    if (paramEmoticonPackage != null)
    {
      ((EmojiManager)paramView1.getManager(42)).a(paramEmoticonPackage, true);
      if ((paramView2 instanceof ProgressButton))
      {
        paramEmoticonPackage = (ProgressButton)paramView2;
        paramEmoticonPackage.setVisibility(0);
        paramEmoticonPackage.setProgress(0);
        paramEmoticonPackage.setTextColor(this.progressDafaultColor);
        paramEmoticonPackage.setTag(Integer.valueOf(2));
        paramEmoticonPackage.setText("取消");
      }
    }
  }
  
  private EmoticonPackageDownloadListener getDownListener(EmoticonPackage paramEmoticonPackage, ProgressButton paramProgressButton)
  {
    return new DragSortAdapter.4(this, paramEmoticonPackage, paramProgressButton);
  }
  
  private DownloaderInterface getDownloader()
  {
    return ((DownloaderFactory)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(46)).a(1);
  }
  
  private Drawable getEPIcon(EmoticonPackage paramEmoticonPackage)
  {
    if (this.mCache.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.mCache.get(paramEmoticonPackage.epId);
    }
    Object localObject = EmosmUtils.getCoverBitmap(2, paramEmoticonPackage.epId);
    if (localObject != null)
    {
      localObject = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject);
      this.mCache.put(paramEmoticonPackage.epId, localObject);
      return localObject;
    }
    return this.mDefaultIcon;
  }
  
  private EmoticonPackageDownloadListener getEmoticonDownloadListener(EmoticonPackage paramEmoticonPackage, ProgressButton paramProgressButton)
  {
    return new DragSortAdapter.3(this, paramEmoticonPackage, paramProgressButton);
  }
  
  private View.OnClickListener getOnClickListener(EmoticonPackage paramEmoticonPackage, View paramView)
  {
    return new DragSortAdapter.2(this, paramEmoticonPackage, paramView);
  }
  
  public void clearCache()
  {
    this.mCache.evictAll();
  }
  
  public void clearSelectStatus()
  {
    this.mSelectStatus.clear();
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public boolean getSelectStatus(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.mSelectStatus.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.mSelectStatus.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public List getSelectedPackages()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mSelectStatus.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.mContext, 2130903306, null);
    }
    paramViewGroup.setVisibility(0);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131296698);
    Object localObject3 = (ImageView)paramViewGroup.findViewById(2131297620);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131296303);
    ((ImageView)paramViewGroup.findViewById(2131297621)).setVisibility(8);
    View localView1 = paramViewGroup.findViewById(2131296569);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.mData.get(paramInt);
    View localView2 = paramViewGroup.findViewById(2131297625);
    localView2.setTag(localEmoticonPackage.epId);
    Object localObject2 = (ProgressButton)paramViewGroup.findViewById(2131297626);
    ((ProgressButton)localObject2).setTag(Integer.valueOf(3));
    ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
    localView2.post(new DragSortAdapter.1(this, (ProgressButton)localObject2));
    ((ProgressButton)localObject2).setOnClickListener(getOnClickListener((EmoticonPackage)this.mData.get(paramInt), localView2));
    paramView = ClubContentJsonTask.a(this.mWordingList, localEmoticonPackage.wordingId, localEmoticonPackage.expiretime);
    Object localObject1;
    if (localEmoticonPackage.valid)
    {
      ((ProgressButton)localObject2).setText(2131368464);
      ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
      ((ProgressButton)localObject2).setTag(Integer.valueOf(0));
      EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(42);
      float f = localEmojiManager.a(localEmoticonPackage.epId);
      if (f >= 0.0F) {
        if (EmoticonUtils.a(localEmoticonPackage))
        {
          ((ProgressButton)localObject2).setText("取消");
          ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
          ((ProgressButton)localObject2).setTag(Integer.valueOf(1));
          localView2.setVisibility(0);
          ((ProgressButton)localObject2).setProgress((int)(f * 100.0F));
          if ("".equals(localEmoticonPackage.updateTip)) {
            break label1121;
          }
          paramView = localEmoticonPackage.updateTip;
          if (this.mIsEdited) {
            localView2.setVisibility(8);
          }
          localObject1 = paramView;
          if (EmoticonUtils.a((EmoticonPackage)this.mData.get(paramInt)))
          {
            ((ProgressButton)localObject2).setText(2131368464);
            ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
            ((ProgressButton)localObject2).setTag(Integer.valueOf(0));
            if (this.mUpdateListener.get(localEmoticonPackage.epId) != null)
            {
              localObject1 = (EmoticonPackageDownloadListener)this.mUpdateListener.get(localEmoticonPackage.epId);
              localEmojiManager.a.b((EmoticonPackageDownloadListener)localObject1);
              this.mUpdateListener.remove(localEmoticonPackage.epId);
            }
            localObject1 = getEmoticonDownloadListener(localEmoticonPackage, (ProgressButton)localObject2);
            this.mDownListener.put(localEmoticonPackage.epId, localObject1);
            localEmojiManager.a.a((EmoticonPackageDownloadListener)localObject1);
            localObject1 = paramView;
          }
          label507:
          localView1.setVisibility(8);
          if (this.mIsEdited) {
            break label1215;
          }
          ((ImageView)localObject3).setVisibility(8);
          localImageView2.setVisibility(8);
          if ((localEmoticonPackage.valid) && (localEmoticonPackage.status == 2))
          {
            if (!EmoticonUtils.a(localEmoticonPackage)) {
              break label1137;
            }
            localView2.setVisibility(0);
            ((ProgressButton)localObject2).setVisibility(0);
            ((ProgressButton)localObject2).setText(2131368464);
            ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
            ((ProgressButton)localObject2).setProgress(0);
            ((ProgressButton)localObject2).setTag(Integer.valueOf(0));
          }
          label604:
          if ((localEmoticonPackage.valid) && (localEmoticonPackage.status != 2))
          {
            localView2.setVisibility(0);
            ((ProgressButton)localObject2).setVisibility(0);
            ((ProgressButton)localObject2).setText(2131368465);
            ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
            ((ProgressButton)localObject2).setTag(Integer.valueOf(3));
            paramView = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(42);
            f = paramView.a(localEmoticonPackage.epId);
            if (f < 0.0F) {
              break label1183;
            }
            ((ProgressButton)localObject2).setVisibility(0);
            ((ProgressButton)localObject2).setText("取消");
            ((ProgressButton)localObject2).setProgress((int)(f * 100.0F));
            ((ProgressButton)localObject2).setTag(Integer.valueOf(2));
            label733:
            if (this.mDownListener.get(localEmoticonPackage.epId) != null)
            {
              localObject3 = (EmoticonPackageDownloadListener)this.mDownListener.get(localEmoticonPackage.epId);
              paramView.a.b((EmoticonPackageDownloadListener)localObject3);
              this.mDownListener.remove(localEmoticonPackage.epId);
            }
            localObject2 = getDownListener(localEmoticonPackage, (ProgressButton)localObject2);
            this.mDownListener.put(localEmoticonPackage.epId, localObject2);
            paramView.a.a((EmoticonPackageDownloadListener)localObject2);
          }
          ((TextView)paramViewGroup.findViewById(2131297623)).setText(localEmoticonPackage.name);
          localImageView1.setImageDrawable(getEPIcon(localEmoticonPackage));
          paramView = (ImageView)paramViewGroup.findViewById(2131296699);
          if (localEmoticonPackage.hasSound != true) {
            break label1261;
          }
          paramView.setVisibility(0);
          label875:
          paramView = (TextView)paramViewGroup.findViewById(2131297624);
          long l = new Date().getTime() / 1000L;
          if ((localEmoticonPackage.expiretime <= l) || ((localEmoticonPackage.expiretime - l) / 86400L >= 1L)) {
            break label1270;
          }
          paramView.setText((CharSequence)localObject1, TextView.BufferType.EDITABLE);
          paramView.getEditableText().setSpan(new ForegroundColorSpan(-65536), 0, ((String)localObject1).length(), 18);
        }
      }
    }
    for (;;)
    {
      if (this.mIsEdited)
      {
        if (!getSelectStatus(paramInt))
        {
          paramViewGroup.setContentDescription(this.mContext.getString(2131368460) + " " + localEmoticonPackage.name + "," + (String)localObject1);
          return paramViewGroup;
          localView2.setVisibility(8);
          break;
          if (EmoticonUtils.a(localEmoticonPackage))
          {
            ((ProgressButton)localObject2).setText(2131368464);
            ((ProgressButton)localObject2).setTextColor(this.progressDafaultColor);
            localView2.setVisibility(0);
            ((ProgressButton)localObject2).setProgress(0);
            ((ProgressButton)localObject2).setTag(Integer.valueOf(0));
            if ("".equals(localEmoticonPackage.updateTip)) {
              break label1121;
            }
            paramView = localEmoticonPackage.updateTip;
            break;
          }
          localView2.setVisibility(8);
          label1121:
          break;
          localView2.setVisibility(8);
          localObject1 = paramView;
          break label507;
          label1137:
          localView2.setVisibility(0);
          ((ProgressButton)localObject2).setVisibility(0);
          ((ProgressButton)localObject2).setProgress(0);
          ((ProgressButton)localObject2).setText("已下载");
          ((ProgressButton)localObject2).setTextColor(-3355444);
          ((ProgressButton)localObject2).setTag(Integer.valueOf(4));
          break label604;
          label1183:
          ((ProgressButton)localObject2).setVisibility(0);
          ((ProgressButton)localObject2).setText(2131368465);
          ((ProgressButton)localObject2).setProgress(0);
          ((ProgressButton)localObject2).setTag(Integer.valueOf(3));
          break label733;
          label1215:
          boolean bool = getSelectStatus(paramInt);
          ((ImageView)localObject3).setVisibility(0);
          if (bool) {
            ((ImageView)localObject3).setImageResource(2130840731);
          }
          for (;;)
          {
            localImageView2.setVisibility(0);
            break;
            ((ImageView)localObject3).setImageResource(2130840730);
          }
          label1261:
          paramView.setVisibility(8);
          break label875;
          label1270:
          paramView.setText((CharSequence)localObject1);
          continue;
        }
        paramViewGroup.setContentDescription(this.mContext.getString(2131368461) + " " + localEmoticonPackage.name + "," + (String)localObject1);
        return paramViewGroup;
      }
    }
    paramViewGroup.setContentDescription(localEmoticonPackage.name + "," + (String)localObject1);
    return paramViewGroup;
  }
  
  public void insert(Object paramObject, int paramInt)
  {
    synchronized (this.mLock)
    {
      this.mData.add(paramInt, paramObject);
      if (this.mNotifyOnChange) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.mNotifyOnChange = true;
  }
  
  public void remove(Object paramObject)
  {
    synchronized (this.mLock)
    {
      if ((paramObject instanceof EmoticonPackage))
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramObject;
        this.mUpdateListener.remove(localEmoticonPackage.epId);
        this.mDownListener.remove(localEmoticonPackage.epId);
      }
      this.mData.remove(paramObject);
      if (this.mNotifyOnChange) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void removeDownloadListeners()
  {
    EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(42);
    int i = 0;
    while (i < this.mData.size())
    {
      localEmojiManager.a.b((EmoticonPackageDownloadListener)this.mDownListener.get(((EmoticonPackage)this.mData.get(i)).epId));
      i += 1;
    }
  }
  
  public void removeUpdateListeners()
  {
    EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(42);
    int i = 0;
    while (i < this.mData.size())
    {
      localEmojiManager.a.b((EmoticonPackageDownloadListener)this.mUpdateListener.get(((EmoticonPackage)this.mData.get(i)).epId));
      i += 1;
    }
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.mIsEdited = paramBoolean;
  }
  
  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.mNotifyOnChange = paramBoolean;
  }
  
  public void setSelected(int paramInt)
  {
    boolean bool = getSelectStatus(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    HashMap localHashMap = this.mSelectStatus;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localEmoticonPackage, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter
 * JD-Core Version:    0.7.0.1
 */