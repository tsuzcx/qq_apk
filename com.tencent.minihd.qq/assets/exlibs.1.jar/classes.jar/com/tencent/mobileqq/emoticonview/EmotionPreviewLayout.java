package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import igr;
import igs;
import igt;
import igu;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EmotionPreviewLayout
  extends LinearLayout
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 10000;
  public static String a;
  static final int jdField_b_of_type_Int = 10001;
  static final int c = 10002;
  static final int d = 3000;
  public static int f = 10000;
  private static final int j = 66;
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public EditText a;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new igs(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new igu(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public List a;
  public String b;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public int e;
  public int g = 0;
  final int h = 2;
  private int i;
  
  static
  {
    jdField_a_of_type_JavaLangString = EmotionPreviewLayout.class.getSimpleName();
  }
  
  public EmotionPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int k = (int)(10.0F * this.jdField_a_of_type_Float);
    setPadding(0, k, k, k);
    this.jdField_a_of_type_AndroidOsHandler = new igr(this);
    getBackground().setAlpha(204);
  }
  
  private String a()
  {
    switch (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
    default: 
      return "5";
    case 1: 
      return "0";
    case 4: 
      return "1";
    case 3: 
      return "2";
    }
    return "3";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int m;
    int k;
    label41:
    EmoticonKeyword localEmoticonKeyword;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt1)) {
      if (this.jdField_a_of_type_JavaUtilList.size() >= paramInt2)
      {
        m = 0;
        k = paramInt1;
        paramInt1 = m;
        if (k >= paramInt2) {
          break label714;
        }
        localEmoticonKeyword = (EmoticonKeyword)this.jdField_a_of_type_JavaUtilList.get(k);
        if (localEmoticonKeyword._index < f) {
          break label586;
        }
        if (paramInt1 != 0) {
          break label715;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_cache", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
        paramInt1 = 1;
      }
    }
    label586:
    label714:
    label715:
    for (;;)
    {
      for (;;)
      {
        label109:
        boolean bool1 = true;
        m = 4;
        if (localEmoticonKeyword.isSound)
        {
          m = 12;
          bool1 = false;
        }
        String str = Integer.toString(m);
        try
        {
          localObject1 = new URL("emotion_pic", "big_img", localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
          boolean bool3 = a(localEmoticonKeyword);
          if ((b(localEmoticonKeyword)) && (!bool3))
          {
            bool2 = true;
            if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
              this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840720));
            }
            if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
              this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840721));
            }
            localView = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903073, null);
            localImageView = (ImageView)localView.findViewById(2131296698);
            localObject1 = URLDrawable.getDrawable((URL)localObject1, localImageView.getWidth(), localImageView.getHeight(), (Drawable)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Drawable)this.jdField_b_of_type_JavaLangRefWeakReference.get(), bool1);
            if (((URLDrawable)localObject1).getStatus() != 1)
            {
              ((URLDrawable)localObject1).setTag(localEmoticonKeyword);
              ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              ((URLDrawable)localObject1).addHeader("emo_tasks", str);
              ((URLDrawable)localObject1).addHeader("image_dl_extra_info", Boolean.toString(bool2));
              if (!bool3) {}
            }
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          try
          {
            for (;;)
            {
              View localView;
              ImageView localImageView;
              ((URLDrawable)localObject1).downloadImediatly();
              localImageView.setTag(localEmoticonKeyword);
              localImageView.setAdjustViewBounds(false);
              localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
              localImageView.setContentDescription("原创表情" + localEmoticonKeyword.name);
              localImageView.setImageDrawable((Drawable)localObject1);
              localImageView.setOnClickListener(this);
              Object localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).width = ((int)(66.0F * this.jdField_a_of_type_Float));
              ((RelativeLayout.LayoutParams)localObject1).height = ((int)(66.0F * this.jdField_a_of_type_Float));
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
              if (localEmoticonKeyword.isSound) {
                ((ImageView)localView.findViewById(2131296699)).setVisibility(0);
              }
              addView(localView);
              this.e += 1;
              k += 1;
              break label41;
              paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
              break;
              if (paramInt1 != 0) {
                break label715;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_local", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
              paramInt1 = 1;
              break label109;
              localMalformedURLException = localMalformedURLException;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "getDrawable ,", localMalformedURLException);
              }
              Object localObject2 = null;
            }
            boolean bool2 = false;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "showEmotions oom,emoj id=" + localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
              }
            }
          }
        }
      }
      return;
    }
  }
  
  private void c()
  {
    if (this.i > this.e)
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {}
      for (Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString(); (localObject1 == null) || (((String)localObject1).equals("")); localObject1 = null) {
        return;
      }
      localObject1 = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903073, null);
      Object localObject2 = (ImageView)((View)localObject1).findViewById(2131296698);
      ((ImageView)localObject2).setAdjustViewBounds(false);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageView)localObject2).setContentDescription("原创表情loading");
      ((ImageView)localObject2).setOnClickListener(this);
      ((ImageView)localObject2).setImageResource(2130840720);
      localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject2 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
      ((ProgressBar)localObject2).setIndeterminateDrawable(getResources().getDrawable(2130838130));
      int k = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.bottomMargin = k;
      localLayoutParams.addRule(13);
      ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
      ((ProgressBar)localObject2).setVisibility(0);
      addView((View)localObject1);
      localObject1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(((EmoticonKeyword)((Iterator)localObject2).next()).eId);
        }
      }
      localObject2 = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
      ((EmosmHandler)localObject2).a(new igt(this, (EmosmHandler)localObject2));
      ((EmosmHandler)localObject2).a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString(), (ArrayList)localObject1);
      return;
    }
    if (this.e > 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000));
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (!paramBoolean) {
      break label4;
    }
    label4:
    while ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    if ((getChildCount() > 0) && (!(getChildAt(getChildCount() - 1).getTag() instanceof EmoticonKeyword))) {
      removeView(getChildAt(getChildCount() - 1));
    }
    int m = this.e;
    int k;
    if (paramArrayList.size() + this.e <= this.i)
    {
      k = paramArrayList.size();
      if (k <= paramArrayList.size()) {
        break label628;
      }
    }
    label103:
    label625:
    label628:
    for (int n = paramArrayList.size();; n = k)
    {
      int i1 = 0;
      k = m;
      EmoticonKeywordForCloud localEmoticonKeywordForCloud;
      View localView;
      if (i1 < n)
      {
        localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)paramArrayList.get(i1);
        m = k;
        if (localEmoticonKeywordForCloud != null)
        {
          if (getChildCount() < 2) {
            break label165;
          }
          m = k;
        }
        for (;;)
        {
          i1 += 1;
          k = m;
          break label103;
          k = this.i - this.e;
          break;
          Object localObject2 = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((PicEmoticonInfo)localObject2).c = 6;
          ((PicEmoticonInfo)localObject2).a = localEmoticonKeywordForCloud;
          ((PicEmoticonInfo)localObject2).j = 3;
          localView = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903073, null);
          localView.setTag(localEmoticonKeywordForCloud);
          Object localObject1 = (ImageView)localView.findViewById(2131296698);
          ((ImageView)localObject1).setTag(localEmoticonKeywordForCloud);
          ((ImageView)localObject1).setAdjustViewBounds(false);
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((ImageView)localObject1).setContentDescription("原创表情" + localEmoticonKeywordForCloud.name);
          ((ImageView)localObject1).setOnClickListener(this);
          ((PicEmoticonInfo)localObject2).h = ((ImageView)localObject1).getWidth();
          ((PicEmoticonInfo)localObject2).i = ((ImageView)localObject1).getHeight();
          localObject2 = ((PicEmoticonInfo)localObject2).a(true);
          m = k;
          if (localObject2 != null)
          {
            ((URLDrawable)localObject2).setTag(localEmoticonKeywordForCloud);
            if (((URLDrawable)localObject2).getStatus() == 1) {
              break label563;
            }
            ((URLDrawable)localObject2).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
            addView(localView);
            localEmoticonKeywordForCloud.loadedType = 1;
            ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
            localProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838130));
            m = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m, m);
            localLayoutParams.bottomMargin = m;
            localLayoutParams.leftMargin = m;
            localLayoutParams.addRule(13);
            ((ViewGroup)localView).addView(localProgressBar, localLayoutParams);
            localProgressBar.setVisibility(0);
            this.g += 1;
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
            m = k;
          }
          localObject1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).width = ((int)(66.0F * this.jdField_a_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject1).height = ((int)(66.0F * this.jdField_a_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
          if (localEmoticonKeywordForCloud.isSound) {
            ((ImageView)localView.findViewById(2131296699)).setVisibility(0);
          }
          this.e += 1;
        }
        if (getChildCount() >= k) {
          break label625;
        }
        k = getChildCount();
      }
      for (;;)
      {
        addView(localView, k);
        k += 1;
        localEmoticonKeywordForCloud.loadedType = 2;
        break label466;
        if (this.g != 0) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
        return;
      }
    }
  }
  
  public boolean a(EmoticonKeyword paramEmoticonKeyword)
  {
    if (paramEmoticonKeyword.jobType == 1) {}
    for (paramEmoticonKeyword = EmosmUtils.getQFaceGifPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);; paramEmoticonKeyword = EmosmUtils.getEmoticonEncryptPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId))
    {
      paramEmoticonKeyword = new File(paramEmoticonKeyword);
      if ((!paramEmoticonKeyword.exists()) || (!paramEmoticonKeyword.isFile())) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    int n = getChildCount();
    int m = 0;
    int k = 0;
    if (m < n)
    {
      if (!(getChildAt(m) instanceof ViewGroup)) {}
      for (;;)
      {
        m += 1;
        break;
        ViewGroup localViewGroup = (ViewGroup)getChildAt(m);
        if ((localViewGroup.getTag() instanceof EmoticonKeywordForCloud))
        {
          EmoticonKeywordForCloud localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)localViewGroup.getTag();
          if (localEmoticonKeywordForCloud.loadedType == 2)
          {
            if ((localViewGroup.getChildAt(localViewGroup.getChildCount() - 1) instanceof ProgressBar)) {
              localViewGroup.getChildAt(localViewGroup.getChildCount() - 1).setVisibility(8);
            }
            if (m > k)
            {
              removeView(localViewGroup);
              addView(localViewGroup, k);
            }
            k += 1;
          }
          for (;;)
          {
            break;
            if (localEmoticonKeywordForCloud.loadedType == 3)
            {
              if ((localViewGroup.getChildAt(localViewGroup.getChildCount() - 1) instanceof ProgressBar)) {
                localViewGroup.getChildAt(localViewGroup.getChildCount() - 1).setVisibility(8);
              }
              removeView(localViewGroup);
              addView(localViewGroup);
            }
          }
        }
        k += 1;
      }
    }
  }
  
  public boolean b(EmoticonKeyword paramEmoticonKeyword)
  {
    if (paramEmoticonKeyword.jobType == 1) {
      paramEmoticonKeyword = EmosmUtils.getEmoticonPreviewPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);
    }
    while (paramEmoticonKeyword != null)
    {
      paramEmoticonKeyword = new File(paramEmoticonKeyword);
      if ((paramEmoticonKeyword.exists()) && (paramEmoticonKeyword.isFile()))
      {
        return true;
        paramEmoticonKeyword = EmosmUtils.getEmoticonAIOPreviewPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().equals(""))) {
      return;
    }
    Object localObject = paramView.getTag();
    EmoticonKeyword localEmoticonKeyword = null;
    if ((localObject instanceof Emoticon)) {
      localEmoticonKeyword = (EmoticonKeyword)paramView.getTag();
    }
    if (localEmoticonKeyword != null)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("emotion onClick, keyword:").append(this.jdField_b_of_type_JavaLangString).append(", epid_eid:");
        if (localEmoticonKeyword.epId == null) {
          break label417;
        }
        paramView = localEmoticonKeyword.epId;
        localStringBuilder = localStringBuilder.append(paramView).append("_");
        if (localEmoticonKeyword.eId == null) {
          break label424;
        }
        paramView = localEmoticonKeyword.eId;
        label161:
        localStringBuilder = localStringBuilder.append(paramView);
        if (!(localEmoticonKeyword instanceof EmoticonKeywordForCloud)) {
          break label431;
        }
        paramView = "-cloud-" + ((EmoticonKeywordForCloud)localEmoticonKeyword).type;
        label203:
        QLog.d((String)localObject, 2, paramView);
      }
      if (!(localEmoticonKeyword instanceof EmoticonKeywordForCloud)) {
        break label438;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_more", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticonKeyword.epId) == null)
      {
        ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(localEmoticonKeyword.epId, EmojiManager.c, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        paramView = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticonKeyword.epId);
        paramView.type = ((EmoticonKeywordForCloud)localEmoticonKeyword).type;
        localObject = (EmoticonManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
        if (localObject != null) {
          ((EmoticonManagerImp)localObject).a(paramView);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localEmoticonKeyword);
      setVisibility(8);
      return;
      label417:
      paramView = "~";
      break;
      label424:
      paramView = "~";
      break label161;
      label431:
      paramView = "-local";
      break label203;
      label438:
      if (localEmoticonKeyword._index >= f) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_cache", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_local", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      }
    }
  }
  
  public void setEmoticonKeywordList(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.i = Math.min(2, paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
        this.jdField_b_of_type_JavaLangString = str;
        this.e = 0;
        this.g = 0;
        a(0, 2);
        if (this.i <= this.e) {
          break label155;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3002L);
        c();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_more", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
        label111:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      str = "";
      break;
      label155:
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      break label111;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewLayout
 * JD-Core Version:    0.7.0.1
 */