package com.tencent.mobileqq.richstatus;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jsq;
import jsr;
import jss;
import jst;
import jsu;
import jsv;
import jsw;
import jsx;
import jsy;
import jsz;
import jta;
import jtb;
import jtd;

public class StatusHistoryActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, IIconListener, IStatusListener, ClickableColorSpanTextView.SpanClickListener, SlideDetectListView.OnScrollToTopListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 1000L;
  public static String a;
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "Q.richstatus.history";
  public static final int c = 2;
  protected static final int d = 1;
  private static final String e = "key__entry_type";
  private static final int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString = "key_uin";
  private static final int jdField_g_of_type_Int = 1;
  private static final String jdField_g_of_type_JavaLangString = "key_uin_name";
  private static final int h = 23;
  private static final int i = 24;
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  private static final int q = 3;
  private static final int r = 0;
  private static final int s = 1;
  private static final int t = 2;
  private static final int u = 3;
  private static final int w = 1;
  private static final int x = 2;
  private static final int y = 3;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public final Handler a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  public AdapterView.OnItemClickListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AIOAnimationConatiner a;
  public SignatureManager a;
  private SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new jsz(this);
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SlideDetectListView.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = new jsx(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new jsw(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap a;
  private jtb jdField_a_of_type_Jtb;
  public boolean a;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public View.OnClickListener b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new jsy(this);
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  protected int e;
  private int j = 0;
  private int k;
  private int l = 24;
  private int m;
  private int v = 0;
  private int z = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "get_more";
  }
  
  public StatusHistoryActivity()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new jsv(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new jta(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new jsr(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载历史签名...");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841979);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("暂无个性签名历史记录");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败，下拉重新加载。");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    paramString3 = new Intent(paramContext, StatusHistoryActivity.class);
    paramString3.putExtra("key_uin", paramString1);
    paramString3.putExtra("key__entry_type", paramInt);
    paramString3.putExtra("key_uin_name", paramString2);
    paramContext.startActivity(paramString3);
  }
  
  private void a(StatusHistoryActivity.ItemViewHolder paramItemViewHolder)
  {
    paramItemViewHolder.b = new ArrayList();
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_Boolean) {
      if (paramItemViewHolder.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        if (paramItemViewHolder.jdField_a_of_type_JavaUtilList.size() <= this.e) {
          break label102;
        }
        int i1 = 0;
        while (i1 < this.e - 1)
        {
          paramItemViewHolder.b.add(paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i1));
          i1 += 1;
        }
        paramItemViewHolder.b.add(jdField_a_of_type_JavaLangString);
      }
    }
    label102:
    do
    {
      do
      {
        do
        {
          return;
          paramItemViewHolder.b.addAll(paramItemViewHolder.jdField_a_of_type_JavaUtilList);
        } while ((this.jdField_b_of_type_JavaUtilHashMap.get(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f) == null) || (((Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f)).booleanValue()));
        paramItemViewHolder.b.add(jdField_a_of_type_JavaLangString);
        return;
      } while (paramItemViewHolder.jdField_a_of_type_JavaUtilList.size() <= 0);
      paramItemViewHolder.b.addAll(paramItemViewHolder.jdField_a_of_type_JavaUtilList);
    } while (((Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f)).booleanValue());
    paramItemViewHolder.b.add(jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    this.jdField_c_of_type_AndroidOsHandler.postDelayed(new jsu(this), 1000L);
  }
  
  private void b(StatusHistoryActivity.ItemViewHolder paramItemViewHolder)
  {
    SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, true);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    Object localObject2 = SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, false);
    if (localObject2 != null) {}
    for (int i1 = ((Layout)localObject2).getLineCount();; i1 = 1)
    {
      float f1;
      Object localObject1;
      if (i1 < 3)
      {
        i1 = 2;
        f1 = 0.35F;
        Object localObject3 = paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        localObject1 = ((SignatureManager)this.app.getManager(56)).a(Integer.toString(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int));
        int i2 = (int)(this.m * f1);
        ((ViewGroup.LayoutParams)localObject3).height = (((Layout)localObject2).getHeight() + Utils.a(this, 77.0F));
        f1 = this.m;
        ((ViewGroup.LayoutParams)localObject3).width = ((int)(((ViewGroup.LayoutParams)localObject3).height / i2 * f1));
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int, i1);
          if (localObject2 != null)
          {
            if (!(localObject2 instanceof URLDrawable)) {
              break label409;
            }
            localObject3 = (URLDrawable)localObject2;
            if (((URLDrawable)localObject3).getStatus() == 1)
            {
              SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, false);
              if (!TextUtils.isEmpty(((SignatureTemplateInfo)localObject1).p)) {
                paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(((SignatureTemplateInfo)localObject1).p));
              }
            }
            ((URLDrawable)localObject3).setURLDrawableListener(new jss(this, paramItemViewHolder));
          }
        }
      }
      for (;;)
      {
        paramItemViewHolder.c.setBackgroundDrawable((Drawable)localObject2);
        if ((SignatureManager.y != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f)))
        {
          i1 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int;
          localObject1 = SignatureManager.y;
          localObject2 = SignatureManager.a;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f, new Object[] { Integer.valueOf(i1), localObject1, localObject2 });
        }
        return;
        if (i1 < 5)
        {
          i1 = 3;
          f1 = 0.46F;
          break;
        }
        i1 = 4;
        f1 = 0.577F;
        break;
        label409:
        SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, false);
        if (!TextUtils.isEmpty(((SignatureTemplateInfo)localObject1).p)) {
          paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(((SignatureTemplateInfo)localObject1).p));
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(1, 2131366939);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_JavaLangString == null) {
      return;
    }
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str1 = str2;
    if (str2.length() == 0) {
      str1 = String.valueOf(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
    str2 = getString(2131361973) + ":";
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str2 + str1);
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 200) || (this.z != 0)) {}
    label148:
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount();
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i1) {
          break label148;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(paramInt2).getTag();
        if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder)))
        {
          localObject = (StatusHistoryActivity.ItemViewHolder)localObject;
          if (((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b == paramInt1)
          {
            if (((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView == null) {
              break;
            }
            ((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.history", 2, "onGetIcon.actionid=" + paramInt1);
            }
          }
        }
        paramInt2 += 1;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.jdField_b_of_type_Long);
  }
  
  public void a(int paramInt, RichStatus paramRichStatus)
  {
    this.rightViewText.setEnabled(true);
    if (paramInt == 100) {
      a(true, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (Arrays.equals(((RichStatus)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a())))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        a(3);
        this.jdField_a_of_type_Jtb.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    a(false, 0L);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = paramClickableColorSpanTextView.getTag();
    if ((paramClickableColorSpanTextView instanceof StatusHistoryActivity.ItemViewHolder))
    {
      paramClickableColorSpanTextView = (StatusHistoryActivity.ItemViewHolder)paramClickableColorSpanTextView;
      if (paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b != 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this, this.jdField_c_of_type_JavaLangString, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.c, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.z = paramInt;
    if ((this.j == 0) && (paramInt == 0))
    {
      URLDrawable.resume();
      this.jdField_a_of_type_Jtb.notifyDataSetChanged();
      a(true, 0L);
      return;
    }
    URLDrawable.pause();
    if (this.j > 0)
    {
      this.j -= 1;
      return;
    }
    a(false, 0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, int paramInt, String paramString2, SignatureTemplateInfo.DynamicItem paramDynamicItem)
  {
    if ((paramString2 == null) || (paramDynamicItem == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(paramInt), paramString2, Boolean.valueOf(false), null, paramDynamicItem });
  }
  
  @TargetApi(9)
  public void a(ArrayList paramArrayList)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131302224);
    TextView localTextView = (TextView)localRelativeLayout.findViewById(2131299826);
    ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131302225);
    int i2 = paramArrayList.size();
    int i1 = i2;
    if (i2 >= 6) {
      i1 = 6;
    }
    i2 = 0;
    for (;;)
    {
      if (i2 < i1)
      {
        if (((RichStatus)paramArrayList.get(i2)).jdField_d_of_type_Int != 0) {
          localTextView.setText(2131369955);
        }
      }
      else
      {
        localRelativeLayout.setOnClickListener(this);
        localImageView.setOnClickListener(this);
        localRelativeLayout.setVisibility(0);
        paramArrayList = this.app.a().getSharedPreferences(this.app.a(), 0);
        if (!paramArrayList.getBoolean("sig_tlp_tip_displayed", false))
        {
          paramArrayList = paramArrayList.edit();
          paramArrayList.putBoolean("sig_tlp_tip_displayed", true);
          paramArrayList.putLong("sig_tlp_tip_last_display_time", System.currentTimeMillis());
          if (Build.VERSION.SDK_INT > 8) {
            break;
          }
          paramArrayList.commit();
        }
        return;
      }
      i2 += 1;
    }
    paramArrayList.apply();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1;
    if (NetworkUtil.e(this)) {
      if (paramBoolean1)
      {
        l1 = 2147483647L;
        int i1 = (int)l1;
        StatusServlet.a(this.app, this.jdField_c_of_type_JavaLangString, 0, i1);
        label33:
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          a(1);
        }
        if (!paramBoolean2) {
          break label124;
        }
        stopTitleProgress();
      }
    }
    label124:
    while (!paramBoolean1)
    {
      return;
      l1 = ((RichStatus)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long - 1L;
      break;
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(0, 1, 0);
      this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      if (paramBoolean1) {
        break label33;
      }
      this.v = 3;
      break label33;
    }
    startTitleProgress();
  }
  
  @TargetApi(9)
  public boolean a()
  {
    if (this.app.a().equals(this.jdField_c_of_type_JavaLangString)) {}
    do
    {
      do
      {
        do
        {
          return false;
          localObject = this.app.a().getSharedPreferences(this.app.a(), 0);
        } while (((SharedPreferences)localObject).getInt("sig_tlp_id", 0) != 0);
        if (!((SharedPreferences)localObject).getBoolean("sig_tlp_tip_displayed", false)) {
          break;
        }
      } while (((SharedPreferences)localObject).getBoolean("sig_tlp_tip_clicked", false));
      long l1 = ((SharedPreferences)localObject).getLong("sig_tlp_tip_last_display_time", 0L);
      if (System.currentTimeMillis() - l1 <= 604800000L) {
        break;
      }
    } while (((SharedPreferences)localObject).getBoolean("sig_tlp_tip_auto_disappear", false));
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sig_tlp_tip_auto_disappear", true);
    if (Build.VERSION.SDK_INT <= 8) {
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "signiture", " his_addclear", 0, 0, "", "", "", "");
      return false;
      ((SharedPreferences.Editor)localObject).apply();
    }
    return true;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_b_of_type_Long);
    a(true, true);
    if (this.app.getAccount().equals(this.jdField_c_of_type_JavaLangString))
    {
      paramView = (SignatureHandler)this.app.a(43);
      if (paramView != null) {
        paramView.a();
      }
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.jdField_b_of_type_Long);
    this.j = 2;
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    a(false, 0L);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    int i1 = SizeMeasure.e(this);
    this.m = (i1 - Util.a(this, 53.0F));
    this.e = ((i1 - Util.a(this, 110.0F)) / Util.a(this, 35.0F));
    if (this.jdField_a_of_type_Jtb != null) {
      this.jdField_a_of_type_Jtb.notifyDataSetChanged();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoBackground(2130904446);
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)this.app.getManager(56));
    int i1 = SizeMeasure.e(this);
    this.m = (i1 - Util.a(this, 53.0F));
    this.e = ((i1 - Util.a(this, 110.0F)) / Util.a(this, 35.0F));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_uin_name");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_uin");
    this.k = getIntent().getIntExtra("key__entry_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new jtd(this, null);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    setTitle("历史签名");
    if (this.app.a().equals(this.jdField_c_of_type_JavaLangString))
    {
      if (this.k != 0)
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText("写签名");
        this.rightViewText.setContentDescription("撰写个性签名入口");
        this.rightViewText.setOnClickListener(this);
      }
      this.l = 23;
    }
    ReportController.b(this.app, "CliOper", "", "", "Modify_signature", "Clk_signature_list", this.l, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((MutilayoutSlideDetectListView)findViewById(2131302229));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904441, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297591));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297590));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131298154)).setTextColor(getResources().getColor(2131427405));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131298155)).setTextColor(getResources().getColor(2131427405));
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904442, null);
    ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302206)).setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302204));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302205));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_b_of_type_AndroidViewView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)findViewById(2131296719));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
    this.jdField_a_of_type_Jtb = new jtb(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Jtb);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new jsq(this, SizeMeasure.e(this) / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    this.jdField_c_of_type_AndroidOsHandler = new jst(this, Looper.myLooper());
    b();
    c();
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    if (this.app.getAccount().equals(this.jdField_c_of_type_JavaLangString))
    {
      paramBundle = (SignatureHandler)this.app.a(43);
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
    findViewById(2131302226).setOnClickListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(56);
    if (localSignatureManager != null) {
      localSignatureManager.a(null);
    }
    a(false, 0L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    a(false, 0L);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    TextView localTextView = this.rightViewText;
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      this.jdField_b_of_type_Boolean = true;
      a(true, false);
      super.doOnResume();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return true;
        stopTitleProgress();
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      } while (paramMessage.arg1 != 1);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        a(2);
      }
      a(1, 2131366939);
      return true;
    }
    this.jdField_a_of_type_Jtb.notifyDataSetChanged();
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("k_source", 4);
      startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_write", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.d();
      }
    }
    do
    {
      return;
      if (paramView == findViewById(2131302226))
      {
        startActivity(new Intent(this, SigCommentListActivity.class));
        paramView.setVisibility(8);
        return;
      }
      if ((paramView == findViewById(2131302224)) || (paramView == findViewById(2131302225)))
      {
        SharedPreferences.Editor localEditor = this.app.a().getSharedPreferences(this.app.a(), 0).edit();
        localEditor.putBoolean("sig_tlp_tip_clicked", true);
        ((RelativeLayout)findViewById(2131302224)).setVisibility(8);
        if (Build.VERSION.SDK_INT <= 8) {
          localEditor.commit();
        }
        while (paramView == findViewById(2131302224))
        {
          startActivity(new Intent(this, EditActivity.class));
          ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_blueadd", 0, 0, "", "", "", "");
          return;
          localEditor.apply();
        }
        ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_addclose", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        paramView = new Intent(this, FriendProfileCardActivity.class);
        paramView.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 5));
        startActivity(paramView);
        ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_pp", 0, 0, "", "", "", "");
        return;
      }
    } while ((!(paramView.getTag() instanceof StatusHistoryActivity.MoreViewHolder)) || (this.v != 3));
    this.v = 1;
    this.jdField_a_of_type_Jtb.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusHistoryActivity
 * JD-Core Version:    0.7.0.1
 */