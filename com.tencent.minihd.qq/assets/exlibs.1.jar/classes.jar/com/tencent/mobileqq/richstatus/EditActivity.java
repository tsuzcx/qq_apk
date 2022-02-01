package com.tencent.mobileqq.richstatus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qqreader.QRBridgeActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.SigTlpGridViewAdapter;
import com.tencent.mobileqq.vas.SigTlpPaperAdapter;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.widget.ClickableImageSpan;
import com.tencent.mobileqq.widget.ClickableImageSpan.ClickableImageSpanListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.MaxHeightRelativelayout;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import jrh;
import jri;
import jrj;
import jrk;
import jrl;
import jrm;
import jrn;
import jro;
import jrp;
import jrq;
import jrr;
import jrs;
import jrt;
import jru;
import jrv;
import jrw;
import jrx;
import jry;
import jrz;
import jsa;
import jsb;
import jsc;
import jsd;
import jse;
import jsf;
import jsg;
import org.json.JSONException;
import org.json.JSONObject;

public class EditActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final int A = 5;
  private static final int B = 6;
  private static final int C = -210006;
  private static final int D = -210007;
  private static final int E = -210008;
  private static final int I = 20;
  private static final int J = 20;
  private static final float jdField_a_of_type_Float = 1.66F;
  public static final int a = 1;
  public static final String a;
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "sp_hot_status";
  public static final int c = 2;
  static final long jdField_c_of_type_Long = 1300L;
  public static final String c = "param_rich_status";
  public static final int d = 3;
  public static final String d = "param_old_xuan_yan";
  public static final int e = 4;
  public static final String e = "param_new_xuan_yan";
  public static final int f = 7;
  public static final String f = "k_action_id";
  private static final boolean f = true;
  public static final int g = 16;
  public static final String g = "k_action_text";
  public static final int h = 17;
  public static final String h = "k_data_id";
  public static final int i = 18;
  public static final String i = "k_data_text";
  public static final int j = 19;
  public static final String j = "param_entry";
  public static final String k = "k_source";
  public static final String l = "k_taskId";
  public static final String m = "SigCommitVIP";
  public static final String n = "#ffa8a8a8";
  public static final int o = 1;
  public static final String o = "tipsbar_clicked";
  public static final int p = 2;
  private static final String q = " ";
  public static final int r = 2000;
  private static final String r = "...";
  private static final int s = 17;
  private static final int t = 18;
  private static final int u = 47;
  private static final int v = 10;
  private int F = 0;
  private int G;
  private int H;
  long jdField_a_of_type_Long = 0L;
  private Intent jdField_a_of_type_AndroidContentIntent;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public final Handler a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new jsf(this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new jrx(this);
  View jdField_a_of_type_AndroidViewView = null;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new jsc(this);
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AIOAnimationConatiner a;
  SVIPHandler jdField_a_of_type_ComTencentMobileqqAppSVIPHandler;
  private SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new jrq(this);
  EditActivity.FixedSpeedScroller jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity$FixedSpeedScroller = null;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new jsd(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new jry(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new jse(this);
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private RichStatusEditText.RichStatusEditListener jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener = new jrl(this);
  private RichStatusEditText jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private SigTlpPaperAdapter jdField_a_of_type_ComTencentMobileqqVasSigTlpPaperAdapter;
  protected SignatureTemplateInfo.DynamicItem a;
  public SignatureTemplateInfo a;
  private ClickableImageSpan.ClickableImageSpanListener jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener = new jrm(this);
  private ClickableImageSpan jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  public ActionSheet a;
  private MaxHeightRelativelayout jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout;
  Runnable jdField_a_of_type_JavaLangRunnable = new jrr(this);
  private int[] jdField_a_of_type_ArrayOfInt = null;
  TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView = null;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private SignatureTemplateInfo jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo = null;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean g = true;
  int k = 0;
  public int l = 0;
  public int m = -1;
  public int n = -1;
  public String p = null;
  public int q;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    jdField_a_of_type_JavaLangString = EditActivity.class.getSimpleName();
  }
  
  public EditActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new jri(this);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = null;
  }
  
  private Drawable a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    Object localObject = new Canvas(Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888));
    ((Canvas)localObject).translate(-paramView.getScrollX(), -paramView.getScrollY());
    paramView.draw((Canvas)localObject);
    paramView.setDrawingCacheEnabled(true);
    localObject = paramView.getDrawingCache().copy(Bitmap.Config.ARGB_8888, true);
    paramView.destroyDrawingCache();
    paramView = new BitmapDrawable(getResources(), (Bitmap)localObject);
    paramView.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    return paramView;
  }
  
  private Drawable a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    this.jdField_d_of_type_Boolean = true;
    a(false, this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setTextColor(Color.parseColor("#ffa8a8a8"));
    Object localObject = (SignatureManager)this.app.getManager(56);
    if ((paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0] != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) && (!((SignatureManager)localObject).b(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString))) {
      ((SignatureManager)localObject).a(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString, paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
    }
    localObject = ((SignatureManager)localObject).a(Integer.parseInt(paramSignatureTemplateInfo.jdField_a_of_type_JavaLangString), 6);
    if ((localObject instanceof URLDrawable))
    {
      paramSignatureTemplateInfo = (URLDrawable)localObject;
      if (paramSignatureTemplateInfo.getStatus() == 1)
      {
        this.jdField_d_of_type_Boolean = false;
        a(false, this.jdField_d_of_type_Boolean);
        if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setTextColor(Color.parseColor(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e));
        }
      }
      paramSignatureTemplateInfo.setURLDrawableListener(new jsa(this));
    }
    do
    {
      return paramSignatureTemplateInfo;
      this.jdField_d_of_type_Boolean = false;
      a(false, this.jdField_d_of_type_Boolean);
      paramSignatureTemplateInfo = (SignatureTemplateInfo)localObject;
    } while (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setTextColor(Color.parseColor(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e));
    return localObject;
  }
  
  private Drawable a(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903354, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131297903);
    TextView localTextView = (TextView)localView.findViewById(2131297904);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString != null) {
      localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString;
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 10) {
      localObject2 = ((String)localObject1).substring(0, 9) + "...";
    }
    localTextView.setText((CharSequence)localObject2);
    if (paramBoolean2)
    {
      localTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b, 200));
      localTextView.setPressed(paramBoolean1);
      if (!paramBoolean1) {
        break label225;
      }
      localView.setBackgroundResource(2130841572);
    }
    for (;;)
    {
      return a(localView);
      if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) {
        break;
      }
      localTextView.setTextColor(Color.parseColor(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.e));
      break;
      label225:
      localView.setBackgroundResource(2130841586);
    }
  }
  
  private View a(SignatureTemplateConfig.SignatureTemplateType paramSignatureTemplateType, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904138, null);
    ((TextView)localRelativeLayout.findViewById(2131300979)).setText(paramSignatureTemplateType.jdField_a_of_type_JavaLangString);
    localRelativeLayout.setOnClickListener(new jsb(this, paramInt, paramSignatureTemplateType));
    localRelativeLayout.setTag(paramSignatureTemplateType.jdField_a_of_type_JavaLangString);
    return localRelativeLayout;
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getByteArray("param_rich_status");
      if ((paramBundle != null) && (paramBundle.length > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.a(paramBundle);
      }
    }
    int i1 = (int)getIntent().getLongExtra("k_action_id", 0L);
    Object localObject;
    if (i1 != 0)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b = i1;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.jdField_d_of_type_JavaLangString;
        ((RichStatus)localObject).jdField_c_of_type_JavaLangString = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int = ((int)getIntent().getLongExtra("k_data_id", 0L));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("k_data_text");
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        paramBundle = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList = paramBundle;
      }
      while (paramBundle.size() < 2) {
        paramBundle.add(null);
      }
      paramBundle = " ";
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ((RichStatus)this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a().clone());
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, true, true);
      }
      return;
    }
    ClickableImageSpan localClickableImageSpan = new ClickableImageSpan(a(false, paramBoolean2), a(true, paramBoolean2));
    if (this.x != 1)
    {
      localClickableImageSpan.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan$ClickableImageSpanListener);
      localClickableImageSpan.a(this.jdField_e_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      localClickableImageSpan.getDrawable().setState(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.getDrawable().getState());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, localClickableImageSpan);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = localClickableImageSpan;
      if (!paramBoolean1) {
        break;
      }
      n();
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().insert(0, "[S]");
      int i1 = "[S]".length();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSpan(localClickableImageSpan, 0, i1);
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i2 + 1];
    arrayOfInt[0] = ((int)((paramInt3 * paramInt2 - paramInt4 * paramInt1) / (paramInt1 + 0.05F)));
    paramInt2 = i1;
    while (paramInt2 < i2)
    {
      arrayOfInt[(paramInt2 + 1)] = ((int)(paramArrayOfInt[paramInt2] * paramInt3 / (paramInt1 + 0.05F)));
      paramInt2 += 1;
    }
    return arrayOfInt;
  }
  
  private void b(boolean paramBoolean)
  {
    RichStatusEditText localRichStatusEditText = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localRichStatusEditText.setCursorVisible(bool);
      if (!paramBoolean) {
        break label86;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.n);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.o)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHintTextColor(Color.parseColor(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.o));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint(null);
    return;
    label86:
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint(null);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(paramBoolean);
    this.jdField_c_of_type_AndroidViewView.setEnabled(paramBoolean);
    this.jdField_d_of_type_AndroidViewView.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setEnabled(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(paramBoolean);
    }
  }
  
  private void d(int paramInt)
  {
    int i2 = 1;
    try
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[this.k].setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131427902)));
      if (paramInt != this.k)
      {
        i1 = 1;
        if (paramInt <= this.k) {
          break label135;
        }
        this.k = paramInt;
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[this.k].setTextColor(Color.parseColor("#18B4ED"));
        if (i1 != 0)
        {
          if (i2 == 0) {
            break label140;
          }
          this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.smoothScrollTo(this.y + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX(), this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollY());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localException.getMessage());
          continue;
          i1 = 0;
          continue;
          label135:
          i2 = 0;
        }
      }
      label140:
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.smoothScrollTo(-this.y + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX(), this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollY());
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在提交签名");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      n();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131368774);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841581);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("连按两次添加位置信息");
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setPadding(Utils.a(this, 8.0F), 0, Utils.a(this, 12.0F), 0);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838522);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131427940));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("所在地:" + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e + "连按两次添加位置信息");
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      c(false);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    c(true);
  }
  
  @SuppressLint({"NewApi"})
  private void i()
  {
    setTitle(2131368782);
    Object localObject1;
    if (getIntent().getStringExtra("k_taskId") == null) {
      localObject1 = "";
    }
    label865:
    ViewGroup.LayoutParams localLayoutParams;
    for (;;)
    {
      setRightHighlightButton(2131368783, new jrs(this, (String)localObject1));
      enableRightHighlight(true);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299594));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131302200);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131302202);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302201));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      localObject1 = a(640, 1136, this.G, this.H, new int[] { 390, 410 });
      float f1 = this.H / this.G;
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131302190));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)findViewById(2131296719));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = new ListView(getBaseContext());
      try
      {
        this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setBackgroundDrawable(getResources().getDrawable(2130840902));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)findViewById(2131302192));
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
        Object localObject2 = this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.getLayoutParams();
        if (f1 > 1.6D)
        {
          ((ViewGroup.LayoutParams)localObject2).height = (localObject1[1] - localObject1[0]);
          this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          float f2 = this.G / ((ViewGroup.LayoutParams)localObject2).height;
          Object localObject3 = (RelativeLayout)findViewById(2131302191);
          localObject4 = ((RelativeLayout)localObject3).getLayoutParams();
          if (f2 <= 1.66F) {
            break label865;
          }
          ((ViewGroup.LayoutParams)localObject4).width = ((int)(((ViewGroup.LayoutParams)localObject4).height * 1.66F));
          ((ViewGroup.LayoutParams)localObject2).height -= Utils.a(this, 20.0F);
          ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setOnTouchListener(new jrz(this));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296828));
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
          this.jdField_c_of_type_AndroidViewView = findViewById(2131302193);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          if (!this.jdField_e_of_type_Boolean) {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
          this.leftView.setContentDescription(this.leftView.getText() + "按钮");
          this.rightViewText.setContentDescription(this.rightViewText.getText() + "按钮");
          this.jdField_c_of_type_AndroidViewView.setContentDescription("做什么按钮");
          this.jdField_d_of_type_AndroidViewView = findViewById(2131302195);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130841582);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297903));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297904));
          if (((ViewGroup.LayoutParams)localObject4).width < Utils.a(this, 172.0F) + this.jdField_c_of_type_AndroidViewView.getWidth()) {
            this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(((ViewGroup.LayoutParams)localObject4).width - Utils.a(this, 65.0F) - this.jdField_c_of_type_AndroidViewView.getWidth());
          }
          this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131302196));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302197));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          localObject2 = new LinearLayout.LayoutParams(this.y, this.z);
          if ((SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) || (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length <= 0)) {
            break label922;
          }
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length];
          this.k = 0;
          localObject3 = SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType;
          int i3 = localObject3.length;
          int i1 = 0;
          int i2 = 0;
          while (i1 < i3)
          {
            localObject4 = a(localObject3[i1], i2);
            this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i2] = ((TextView)((View)localObject4).findViewById(2131300979));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject2);
            i2 += 1;
            i1 += 1;
            continue;
            localObject1 = getIntent().getStringExtra("k_taskId");
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject4;
          this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setBackgroundColor(Color.parseColor("#dedede"));
          continue;
          if (f1 >= 1.5D)
          {
            localException.height = localObject1[1];
          }
          else
          {
            localException.height = Utils.a(this, 150.0F);
            continue;
            ((ViewGroup.LayoutParams)localObject4).width = (this.G - Utils.a(this, 60.0F));
            ((ViewGroup.LayoutParams)localObject4).height = ((int)(((ViewGroup.LayoutParams)localObject4).width / 1.66F));
          }
        }
        if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length > 0) {
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setTextColor(Color.parseColor("#18B4ED"));
        }
        label922:
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131302198));
        localLayoutParams = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams();
        if (f1 <= 1.6D) {}
      }
    }
    for (localLayoutParams.height = localObject1[2];; localLayoutParams.height = (localObject1[2] / 2))
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("VIEWPAGERHEIGHT", 2, "Compute:" + localObject1[2] + " Actual:" + this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getHeight());
      }
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new jsg(this));
      this.jdField_a_of_type_ComTencentMobileqqVasSigTlpPaperAdapter = new SigTlpPaperAdapter(this.app, this, this.F, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasSigTlpPaperAdapter);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302199));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      findViewById(2131302190).setOnClickListener(this);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  private void j()
  {
    if (this.app.a().getSharedPreferences(this.app.a(), 0).getBoolean("tipsbar_clicked", false))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
    {
      if (SignatureManager.a(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_Int > 1)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.f() == 0))
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369944);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.f() != 3))
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131369945);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void k()
  {
    int i1 = 0;
    if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {
      return;
    }
    if (this.H / this.G < 1.6D) {
      SigTlpGridViewAdapter.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length];
    if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length > 0) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    int i2 = 0;
    while (i1 < SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
    {
      int i5 = SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].jdField_a_of_type_JavaUtilArrayList.size();
      int i4 = i5 / SigTlpGridViewAdapter.jdField_a_of_type_Int;
      int i3 = i4;
      if (i5 % 4 != 0) {
        i3 = i4 + 1;
      }
      i2 += i3;
      if (i1 != SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length - 1) {
        this.jdField_a_of_type_ArrayOfInt[(i1 + 1)] = (i3 + this.jdField_a_of_type_ArrayOfInt[i1]);
      }
      i1 += 1;
    }
    this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo = a(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int));
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131302198));
    }
    this.F = i2;
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
    {
      Drawable localDrawable = a(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo);
      if (localDrawable != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setBackgroundDrawable(localDrawable);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setPadding(Utils.a(this, 20.0F), Utils.a(this, 20.0F), Utils.a(this, 20.0F), Utils.a(this, 20.0F));
    }
  }
  
  private void m()
  {
    this.g = false;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList.get(0) != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)localArrayList.get(0));
    }
    if (localArrayList.get(1) != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)localArrayList.get(1));
    }
    e(false);
    this.g = true;
    n();
    b(true);
  }
  
  private void n()
  {
    if (!this.g) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {}
    for (int i1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan), 0);; i1 = 0)
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().length();
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.add(null);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.set(0, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().subSequence(i1, i2).toString());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.set(1, null);
      i1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b();
      String str = Integer.toString(47 - i1);
      if (i1 > 47)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), 0, str.length(), 33);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void o()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131365995)).setMessage(getString(2131369953)).setPositiveButton(getString(2131369954), new jrk(this)).setNegativeButton(getString(2131366212), new jrj(this));
    h();
    localQQCustomDialog.show();
  }
  
  public SignatureTemplateInfo a(String paramString)
  {
    if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
    {
      int i1 = 0;
      while (i1 < SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
      {
        int i2 = 0;
        while (i2 < SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].jdField_a_of_type_JavaUtilArrayList.size())
        {
          SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].jdField_a_of_type_JavaUtilArrayList.get(i2);
          if (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals(paramString))
          {
            this.m = (this.jdField_a_of_type_ArrayOfInt[i1] + i2 / SigTlpGridViewAdapter.jdField_a_of_type_Int);
            this.n = (i2 % SigTlpGridViewAdapter.jdField_a_of_type_Int);
            return localSignatureTemplateInfo;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      if (paramString.equals("0"))
      {
        this.m = 0;
        this.n = 0;
        return new SignatureTemplateInfo("0");
      }
      return a("0");
    }
    return null;
  }
  
  public void a()
  {
    if (this.x == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b() > 47)
      {
        a(2131368779);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("param_new_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a());
      setResult(-1, localIntent);
      finish();
      return;
    }
    if ((jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      o();
      return;
    }
    finish();
  }
  
  public void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt, SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo = paramSignatureTemplateInfo;
    paramSignatureTemplateInfo = a(paramSignatureTemplateInfo);
    if ((paramSignatureTemplateInfo != null) && ((paramSignatureTemplateInfo instanceof URLDrawable)))
    {
      paramSignatureTemplateInfo = (URLDrawable)paramSignatureTemplateInfo;
      if (paramSignatureTemplateInfo.getStatus() == 2) {
        paramSignatureTemplateInfo.restartDownload();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setBackgroundDrawable(paramSignatureTemplateInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setPadding(Utils.a(this, 20.0F), Utils.a(this, 20.0F), Utils.a(this, 20.0F), Utils.a(this, 20.0F));
      this.n = paramInt;
      this.m = this.l;
      paramSignatureTemplateInfo = (GridView)this.jdField_a_of_type_ComTencentMobileqqVasSigTlpPaperAdapter.a.get(this.l);
      if (paramSignatureTemplateInfo != null) {
        ((BaseAdapter)paramSignatureTemplateInfo.getAdapter()).notifyDataSetChanged();
      }
      this.p = SignatureManager.y;
      this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = SignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
      if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
      {
        a(false);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setBackgroundDrawable(paramSignatureTemplateInfo);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(paramString1), paramString2, Boolean.valueOf(false), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem });
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 16)
    {
      ReportController.b(this.app, "CliOper", "", "", "signiture", "sig_tlp_pay", 0, 0, "", "", "", "");
      DialogUtil.a(this, 230).setTitle(getString(2131365995)).setMessage(getString(2131369942)).setPositiveButton(getString(2131369145), new jru(this)).setNegativeButton(getString(2131365736), new jrt(this)).show();
      return false;
    }
    if ((paramInt == 18) || (paramInt == 19))
    {
      DialogUtil.a(this, 230).setTitle(getString(2131365995)).setMessage(getString(2131369943)).setPositiveButton(getString(2131369145), new jrw(this)).setNegativeButton(getString(2131365736), new jrv(this)).show();
      return false;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(2131368787);
      setResult(-1);
      finish();
    }
    return true;
  }
  
  public void b()
  {
    ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_save", 0, 0, "", "", "", "");
    if (!NetworkUtil.e(this))
    {
      a(2131368778);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b() > 47)
    {
      a(2131368779);
      ReportController.b(this.app, "CliOper", "", "", "signiture", "set_err_overnum", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getLineCount() > 7)
    {
      a(2131368780);
      return;
    }
    c();
  }
  
  @SuppressLint({"NewApi"})
  public void b(int paramInt)
  {
    if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {}
    SignatureTemplateInfo localSignatureTemplateInfo;
    do
    {
      int i1;
      do
      {
        return;
        i1 = (this.l - this.jdField_a_of_type_ArrayOfInt[this.k]) * SigTlpGridViewAdapter.jdField_a_of_type_Int + paramInt;
      } while (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[this.k].jdField_a_of_type_JavaUtilArrayList.size() <= i1);
      localSignatureTemplateInfo = (SignatureTemplateInfo)SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[this.k].jdField_a_of_type_JavaUtilArrayList.get(i1);
    } while (localSignatureTemplateInfo == null);
    ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_mdl_id", 0, 0, "" + localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, "", "", "");
    a(paramInt, localSignatureTemplateInfo);
  }
  
  protected void c()
  {
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    int i1;
    if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
    {
      i1 = Integer.parseInt(this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString);
      localRichStatus.jdField_d_of_type_Int = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList == null) {
        break label170;
      }
      localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.get(0))) {
        break label165;
      }
      i1 = 0;
      label68:
      localRichStatus.g = i1;
      if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.get(0))) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e = null;
      }
      label115:
      if (Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a().a(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a())) {
        break label189;
      }
      f(true);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.w);
    }
    label165:
    label170:
    label189:
    long l1;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 1;
      break label68;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.g = 0;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e = null;
      break label115;
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long <= 2000L);
    a(2131369952);
    this.jdField_a_of_type_Long = l1;
  }
  
  public void c(int paramInt)
  {
    String str2 = "CJCLUBT";
    String str1 = getString(2131369212);
    if (paramInt == 1)
    {
      str2 = "LTMCLUB";
      str1 = getString(2131369043);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.a());
      localJSONObject.put("openMonth", 3);
      localJSONObject.put("aid", "mvip.gexinghua.android.signature_" + this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("offerId", "1450000515");
      localJSONObject.put("serviceName", str1);
      localJSONObject.put("serviceCode", str2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 4, "SigCommitVIP");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void d()
  {
    ReportController.b(this.app, "CliOper", "", "", "Rich_status", "Clk_what2do", 0, 0, "", "", "", "");
    startActivityForResult(new Intent(this, ActionListActivity.class), 17);
    overridePendingTransition(2130968586, 2130968592);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (bool) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getParent().requestDisallowInterceptTouchEvent(true);
      }
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramMotionEvent.toString());
      }
    }
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 17) {
        break label173;
      }
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        break label154;
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b = ((int)this.jdField_a_of_type_AndroidContentIntent.getLongExtra("k_action_id", 0L));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b);
        RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (localObject == null) {
          break label166;
        }
        localObject = ((ActionInfo)localObject).jdField_d_of_type_JavaLangString;
        label104:
        localRichStatus.jdField_c_of_type_JavaLangString = ((String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int = ((int)paramIntent.getLongExtra("k_data_id", 0L));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("k_data_text");
      a(true, this.jdField_d_of_type_Boolean);
      e(true);
    }
    label154:
    label166:
    label173:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
        break;
        localObject = " ";
        break label104;
      } while (paramInt1 != 18);
      paramIntent = (LbsDataV2.PoiInfo)paramIntent.getParcelableExtra("key_select_poi");
    } while (paramIntent == null);
    if (!paramIntent.poiName.equals("不显示")) {}
    for (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e = paramIntent.poiName;; this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e = "")
    {
      if (paramIntent.gpsInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_i_of_type_Int = paramIntent.gpsInfo.lat;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.h = paramIntent.gpsInfo.lon;
      }
      e(true);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904440);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.G = SizeMeasure.e(this);
    this.H = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.app.a(12));
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater"));
    this.y = ((int)BaseApplicationImpl.getContext().getResources().getDimension(2131493422));
    this.z = ((int)BaseApplicationImpl.getContext().getResources().getDimension(2131493423));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#dedede"));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null)
    {
      a(2131366833);
      finish();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a())
    {
      a(2131368777);
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    this.x = getIntent().getIntExtra("param_entry", 0);
    if (this.x == 1)
    {
      setTitle("交友宣言");
      setLeftViewName(2131365114);
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131302190));
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight((int)(getResources().getDisplayMetrics().heightPixels * 0.31D));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296828));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427975));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText = ((RichStatusEditText)findViewById(2131302192));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setHint("你想对附近的人说点什么？");
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener);
      paramBundle = getIntent().getByteArrayExtra("param_old_xuan_yan");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.a(paramBundle);
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList;
        if (paramBundle != null) {
          break label823;
        }
        paramBundle = new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList = paramBundle;
      }
    }
    label823:
    for (;;)
    {
      if (paramBundle.size() < 2)
      {
        paramBundle.add(null);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setText("");
      a(false, this.jdField_d_of_type_Boolean);
      if (paramBundle.get(0) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(0));
      }
      if (paramBundle.get(1) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().append((CharSequence)paramBundle.get(1));
      }
      n();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131302195);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131302193);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297582));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131302198));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302199));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131302190));
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setBackgroundResource(2130841912);
      for (;;)
      {
        this.app.a(EditActivity.class, this.jdField_a_of_type_AndroidOsHandler);
        this.p = SignatureManager.y;
        this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = SignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
        if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
        {
          a(false);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
        }
        return true;
        a(paramBundle);
        k();
        i();
        m();
        l();
        j();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.w = getIntent().getIntExtra("k_source", -1);
        super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
        ThreadManager.b(new jrh(this));
        jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.x != 1) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEnabled(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setEditListener(null);
    }
    this.app.a(EditActivity.class);
    h();
    a(true);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((this.x == 1) || (paramIntent.getIntExtra("k_source", 4) == 4)) {
      return;
    }
    if (this.w == -1) {
      this.w = getIntent().getIntExtra("k_source", -1);
    }
    doOnActivityResult(17, -1, paramIntent);
  }
  
  protected void doOnPause()
  {
    this.jdField_c_of_type_Boolean = false;
    h();
    a(true);
    super.doOnPause();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    this.g = false;
    super.doOnRestoreInstanceState(paramBundle);
    this.g = true;
  }
  
  protected void doOnResume()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.x == 1) {
      g();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
    {
      a(false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) {
      paramBundle.putByteArray("param_rich_status", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a());
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(0);
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setVisibility(4);
    super.doOnStop();
  }
  
  public void e()
  {
    ReportController.b(this.app, "CliOper", "", "", "Rich_status", "Clk_where", 0, 0, "", "", "", "");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    localUserInfo.b = this.app.c();
    localUserInfo.jdField_c_of_type_JavaLangString = this.app.getSid();
    QZoneHelper.c(this, localUserInfo, 18);
    overridePendingTransition(2130968586, 2130968592);
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131368775, 0);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131368776, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new jrn(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new jro(this));
  }
  
  public void g()
  {
    b(false);
    new Handler().postDelayed(new jrp(this), 500L);
  }
  
  public void h()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(((Integer)paramMessage.obj).intValue());
      continue;
      if (SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
      {
        k();
        i();
        l();
        this.jdField_a_of_type_ComTencentMobileqqVasSigTlpPaperAdapter.notifyDataSetChanged();
        n();
        j();
        this.p = SignatureManager.y;
        this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = SignatureManager.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
        continue;
        if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
        {
          a(false);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
          continue;
          paramMessage = (GridView)this.jdField_a_of_type_ComTencentMobileqqVasSigTlpPaperAdapter.a.get(((Integer)paramMessage.obj).intValue());
          if (paramMessage != null)
          {
            paramMessage = (BaseAdapter)paramMessage.getAdapter();
            if (paramMessage != null)
            {
              paramMessage.notifyDataSetChanged();
              continue;
              b(false);
              continue;
              e();
              continue;
              d();
            }
          }
        }
      }
    }
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: aload_0
    //   4: iload_1
    //   5: iload_2
    //   6: aload_3
    //   7: invokespecial 1677	com/tencent/mobileqq/app/IphoneTitleBarActivity:onActivityResult	(IILandroid/content/Intent;)V
    //   10: iload_1
    //   11: iconst_4
    //   12: if_icmpne +123 -> 135
    //   15: aload_3
    //   16: ifnull +119 -> 135
    //   19: aload_3
    //   20: ldc_w 1679
    //   23: invokevirtual 579	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: pop
    //   27: aload_3
    //   28: ldc_w 1681
    //   31: invokevirtual 579	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_3
    //   35: new 1301	org/json/JSONObject
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 1682	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore 6
    //   45: aload 6
    //   47: ldc_w 1684
    //   50: invokevirtual 1686	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 411	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   56: istore_2
    //   57: aload 6
    //   59: ldc_w 1688
    //   62: invokevirtual 1686	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 411	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: istore_1
    //   69: aload 6
    //   71: ldc_w 1690
    //   74: invokevirtual 1686	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 411	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore 5
    //   82: iload 5
    //   84: istore 4
    //   86: aload 6
    //   88: ifnull +47 -> 135
    //   91: iload_2
    //   92: ifne +43 -> 135
    //   95: iload_1
    //   96: ifne +39 -> 135
    //   99: iload 4
    //   101: ifne +34 -> 135
    //   104: invokestatic 1691	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   107: invokestatic 1257	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   110: ifne +25 -> 135
    //   113: aload_0
    //   114: invokevirtual 1694	com/tencent/mobileqq/richstatus/EditActivity:getApplicationContext	()Landroid/content/Context;
    //   117: aload_0
    //   118: invokevirtual 856	com/tencent/mobileqq/richstatus/EditActivity:getBaseContext	()Landroid/content/Context;
    //   121: ldc_w 1695
    //   124: invokevirtual 1696	android/content/Context:getString	(I)Ljava/lang/String;
    //   127: iconst_0
    //   128: invokestatic 1699	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   131: invokevirtual 1702	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   134: pop
    //   135: return
    //   136: astore_3
    //   137: iconst_m1
    //   138: istore_2
    //   139: aconst_null
    //   140: astore 6
    //   142: iconst_m1
    //   143: istore_1
    //   144: aload_3
    //   145: invokevirtual 1335	org/json/JSONException:printStackTrace	()V
    //   148: goto -62 -> 86
    //   151: astore_3
    //   152: iconst_m1
    //   153: istore_1
    //   154: iconst_m1
    //   155: istore_2
    //   156: goto -12 -> 144
    //   159: astore_3
    //   160: iconst_m1
    //   161: istore_1
    //   162: goto -18 -> 144
    //   165: astore_3
    //   166: goto -22 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	EditActivity
    //   0	169	1	paramInt1	int
    //   0	169	2	paramInt2	int
    //   0	169	3	paramIntent	Intent
    //   1	99	4	i1	int
    //   80	3	5	i2	int
    //   43	98	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   35	45	136	org/json/JSONException
    //   45	57	151	org/json/JSONException
    //   57	69	159	org/json/JSONException
    //   69	82	165	org/json/JSONException
  }
  
  protected boolean onBackEvent()
  {
    if ((jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      o();
      return true;
    }
    return super.onBackEvent();
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    a(true);
    switch (paramView.getId())
    {
    case 2131302194: 
    case 2131302196: 
    case 2131302197: 
    case 2131302198: 
    case 2131302201: 
    default: 
      if (paramView.getId() != 2131302192) {
        h();
      }
    case 2131302193: 
    case 2131302195: 
      do
      {
        return;
        h();
        d();
        ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_do", 0, 0, "", "", "", "");
        return;
      } while (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1300L);
      h();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e)) {
        e();
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "signiture", "set_clk_pnt", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
          f();
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
    case 2131302199: 
      b();
      return;
    case 2131302200: 
      if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_Int != 2) {
          break label305;
        }
        c(1);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramView = this.app.a().getSharedPreferences(this.app.a(), 0).edit();
        paramView.putBoolean("tipsbar_clicked", true);
        if (Build.VERSION.SDK_INT > 8) {
          break;
        }
        paramView.commit();
        return;
        label305:
        if (this.jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_Int == 3) {
          c(2);
        }
      }
      paramView.apply();
      return;
    }
    paramView = this.app.a().getSharedPreferences(this.app.a(), 0).edit();
    paramView.putBoolean("tipsbar_clicked", true);
    if (Build.VERSION.SDK_INT <= 8) {
      paramView.commit();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
      paramView.apply();
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = ((Integer)paramView.getTag()).intValue();
    paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt);
    if (paramView == null) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtra("k_action_id", paramView.jdField_i_of_type_Int);
      localIntent.putExtra("k_action_text", paramView.jdField_d_of_type_JavaLangString);
      if (paramView.j == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString = paramView.jdField_d_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = null;
        a(true, this.jdField_d_of_type_Boolean);
        e(true);
        return;
      }
    } while (paramView.j == 0);
    for (;;)
    {
      try
      {
        paramInt = paramView.j;
        switch (paramInt)
        {
        default: 
          paramAdapterView = null;
        }
      }
      catch (Exception paramView)
      {
        try
        {
          AdapterView localAdapterView;
          label165:
          paramAdapterView.putExtra("param_plugin_gesturelock", true);
          if (paramView.jdField_i_of_type_JavaLangString != null) {
            paramAdapterView.putExtra("key_params_qq", this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramView.jdField_i_of_type_JavaLangString, paramView.jdField_i_of_type_Int, 0, ""));
          }
          if (!QRBridgeActivity.jdField_b_of_type_Boolean)
          {
            paramView = new QQProgressDialog(this, getTitleBarHeight());
            paramView.a("正在加载...");
            new SplashDialogWrapper(this, paramView, "阅读中心", "qqreaderplugin.apk", true, 10000).show();
            QRBridgeActivity.jdField_b_of_type_Boolean = true;
          }
        }
        catch (Exception paramView) {}
        paramView = paramView;
        paramAdapterView = null;
        continue;
        continue;
      }
      localAdapterView = paramAdapterView;
      if (localAdapterView != null)
      {
        this.jdField_a_of_type_AndroidContentIntent = localIntent;
        startActivityForResult(localAdapterView, 17);
        return;
        paramAdapterView = new Intent(this, ActionListActivity.class);
        try
        {
          paramAdapterView.putExtra("k_action_id", paramView.jdField_i_of_type_Int);
        }
        catch (Exception paramView) {}
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          localAdapterView = paramAdapterView;
          if (!QLog.isColorLevel()) {
            break label165;
          }
          QLog.e("Q.richstatus.", 2, paramView.getStackTrace().toString());
          localAdapterView = paramAdapterView;
          break label165;
          break;
          paramAdapterView = new Intent(this, ActionGridActivity.class);
          try
          {
            paramAdapterView.putExtra("k_action_id", paramView.jdField_i_of_type_Int);
          }
          catch (Exception paramView) {}
        }
        continue;
        paramView = paramView.e.replace("$A", this.app.a());
        paramAdapterView = new Intent(this, ActionUrlActivity.class);
        try
        {
          paramAdapterView.putExtra("key_params_qq", paramView);
        }
        catch (Exception paramView) {}
      }
    }
    paramAdapterView = new Intent(this, Class.forName(paramView.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity
 * JD-Core Version:    0.7.0.1
 */