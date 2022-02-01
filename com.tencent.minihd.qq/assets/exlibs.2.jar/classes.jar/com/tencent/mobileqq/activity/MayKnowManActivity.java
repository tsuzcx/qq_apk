package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cannon.Visitor;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import ekb;
import ekc;
import ekd;
import ekg;
import ekh;
import ekj;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class MayKnowManActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  static final int jdField_a_of_type_Int = 30000;
  public static final String a;
  static final int jdField_b_of_type_Int = 10;
  private static final String jdField_b_of_type_JavaLangString = "_may_known";
  public Dialog a;
  public View a;
  public LinearLayout a;
  public TextView a;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new ekd(this);
  public XListView a;
  public ekj a;
  public List a;
  public boolean a;
  public TextView b;
  public int c = 1;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = MayKnowManActivity.class.getSimpleName();
  }
  
  public MayKnowManActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  /* Error */
  public static List a(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 82	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 88	com/tencent/mobileqq/app/BaseActivity:getFilesDir	()Ljava/io/File;
    //   12: new 90	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   19: aload_1
    //   20: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 15
    //   25: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 97
    //   30: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 103	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +276 -> 317
    //   44: aload_1
    //   45: invokevirtual 107	java/io/File:exists	()Z
    //   48: ifeq +269 -> 317
    //   51: new 109	java/io/ByteArrayInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokestatic 114	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   59: invokespecial 117	java/io/ByteArrayInputStream:<init>	([B)V
    //   62: astore_1
    //   63: new 119	java/io/ObjectInputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 122	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_3
    //   72: aload_1
    //   73: astore 4
    //   75: aload_3
    //   76: astore_2
    //   77: aload_3
    //   78: invokevirtual 126	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 128	java/util/List
    //   84: astore 5
    //   86: aload_1
    //   87: astore_2
    //   88: aload 5
    //   90: astore_1
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 131	java/io/ObjectInputStream:close	()V
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 132	java/io/ByteArrayInputStream:close	()V
    //   107: aload_0
    //   108: getfield 136	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   111: bipush 8
    //   113: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   116: checkcast 144	com/tencent/mobileqq/app/FriendsManagerImp
    //   119: astore_0
    //   120: aload_1
    //   121: ifnull +159 -> 280
    //   124: aload_0
    //   125: ifnull +155 -> 280
    //   128: aload_1
    //   129: invokeinterface 148 1 0
    //   134: astore_2
    //   135: aload_2
    //   136: invokeinterface 153 1 0
    //   141: ifeq +139 -> 280
    //   144: aload_0
    //   145: new 90	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   152: aload_2
    //   153: invokeinterface 156 1 0
    //   158: checkcast 158	cannon/Visitor
    //   161: getfield 162	cannon/Visitor:uin	J
    //   164: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   167: ldc 167
    //   169: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 170	com/tencent/mobileqq/app/FriendsManagerImp:b	(Ljava/lang/String;)Z
    //   178: ifeq -43 -> 135
    //   181: aload_2
    //   182: invokeinterface 173 1 0
    //   187: goto -52 -> 135
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   195: goto -88 -> 107
    //   198: astore 5
    //   200: aconst_null
    //   201: astore 6
    //   203: aconst_null
    //   204: astore_1
    //   205: aload 6
    //   207: astore 4
    //   209: aload_1
    //   210: astore_2
    //   211: aload 5
    //   213: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 131	java/io/ObjectInputStream:close	()V
    //   224: aload 6
    //   226: ifnull +8 -> 234
    //   229: aload 6
    //   231: invokevirtual 132	java/io/ByteArrayInputStream:close	()V
    //   234: aconst_null
    //   235: astore_1
    //   236: goto -129 -> 107
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -139 -> 107
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: aload_2
    //   255: ifnull +7 -> 262
    //   258: aload_2
    //   259: invokevirtual 131	java/io/ObjectInputStream:close	()V
    //   262: aload_1
    //   263: ifnull +7 -> 270
    //   266: aload_1
    //   267: invokevirtual 132	java/io/ByteArrayInputStream:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   277: goto -7 -> 270
    //   280: aload_1
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_2
    //   285: goto -31 -> 254
    //   288: astore_0
    //   289: aload 4
    //   291: astore_1
    //   292: goto -38 -> 254
    //   295: astore 5
    //   297: aconst_null
    //   298: astore_2
    //   299: aload_1
    //   300: astore 6
    //   302: aload_2
    //   303: astore_1
    //   304: goto -99 -> 205
    //   307: astore 5
    //   309: aload_1
    //   310: astore 6
    //   312: aload_3
    //   313: astore_1
    //   314: goto -109 -> 205
    //   317: aconst_null
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_3
    //   321: goto -230 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	324	1	paramString	String
    //   3	179	2	localObject1	Object
    //   190	2	2	localIOException	java.io.IOException
    //   210	93	2	str1	String
    //   1	320	3	localObjectInputStream	java.io.ObjectInputStream
    //   73	217	4	localObject2	Object
    //   84	5	5	localList	List
    //   198	14	5	localException1	java.lang.Exception
    //   295	1	5	localException2	java.lang.Exception
    //   307	1	5	localException3	java.lang.Exception
    //   201	110	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   95	99	190	java/io/IOException
    //   103	107	190	java/io/IOException
    //   4	40	198	java/lang/Exception
    //   44	63	198	java/lang/Exception
    //   220	224	239	java/io/IOException
    //   229	234	239	java/io/IOException
    //   4	40	249	finally
    //   44	63	249	finally
    //   258	262	272	java/io/IOException
    //   266	270	272	java/io/IOException
    //   63	72	282	finally
    //   77	86	288	finally
    //   211	216	288	finally
    //   63	72	295	java/lang/Exception
    //   77	86	307	java/lang/Exception
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, MayKnowManActivity.class));
  }
  
  /* Error */
  public static void a(Context paramContext, List paramList, String paramString)
  {
    // Byte code:
    //   0: new 192	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 193	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 195	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 198	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 202	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: invokevirtual 205	java/io/ObjectOutputStream:flush	()V
    //   37: aload 4
    //   39: astore_3
    //   40: new 82	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokevirtual 206	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: new 90	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   55: aload_2
    //   56: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 15
    //   61: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 97
    //   66: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 103	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: aload 5
    //   80: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: iconst_0
    //   84: invokestatic 216	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   87: pop
    //   88: aload 4
    //   90: ifnull +8 -> 98
    //   93: aload 4
    //   95: invokevirtual 217	java/io/ObjectOutputStream:close	()V
    //   98: return
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   104: return
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: astore_3
    //   110: aload_1
    //   111: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   114: aload_0
    //   115: ifnull -17 -> 98
    //   118: aload_0
    //   119: invokevirtual 217	java/io/ObjectOutputStream:close	()V
    //   122: return
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   128: return
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_3
    //   132: aload_3
    //   133: ifnull +7 -> 140
    //   136: aload_3
    //   137: invokevirtual 217	java/io/ObjectOutputStream:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_0
    //   151: goto -19 -> 132
    //   154: astore_1
    //   155: aload 4
    //   157: astore_0
    //   158: goto -50 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   0	161	1	paramList	List
    //   0	161	2	paramString	String
    //   22	115	3	localObject	Object
    //   18	138	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   7	72	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   93	98	99	java/io/IOException
    //   0	20	105	java/lang/Exception
    //   118	122	123	java/io/IOException
    //   0	20	129	finally
    //   136	140	142	java/io/IOException
    //   23	29	150	finally
    //   32	37	150	finally
    //   40	88	150	finally
    //   110	114	150	finally
    //   23	29	154	java/lang/Exception
    //   32	37	154	java/lang/Exception
    //   40	88	154	java/lang/Exception
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.e(this.app.getApplication()))
    {
      QQToast.a(this.app.getApplication(), 2131365941, 0).b(getTitleBarHeight());
      return false;
    }
    ((LBSHandler)this.app.a(3)).a(paramInt1, paramInt2);
    return true;
  }
  
  private void c()
  {
    int i = (int)DisplayUtils.a(this, 8.0F);
    ((RelativeLayout.LayoutParams)this.centerView.getLayoutParams()).setMargins(i, 0, i, 0);
    setTitle(2131366593);
    View localView = findViewById(2131297981);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297983));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297984));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131297982));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903377, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297997));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366569);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new ekc(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
  }
  
  private void d()
  {
    b();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, this.d);
    localQQProgressDialog.a(getString(2131368001));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ekg(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new ekh(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a()
  {
    int i = this.c + 1;
    this.c = i;
    if (a(10, i))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366594);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131296735);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297996);
      localProgressBar.setVisibility(0);
      localImageView.setVisibility(8);
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ekj != null) {
      this.jdField_a_of_type_Ekj.notifyDataSetChanged();
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      if (this.jdField_a_of_type_Boolean) {
        a();
      }
    }
    while ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return;
    }
    Object localObject = (Visitor)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramAdapterView = (FriendManager)this.app.getManager(8);
    localObject = String.valueOf(((Visitor)localObject).uin);
    if (paramAdapterView.b((String)localObject)) {}
    for (paramAdapterView = new ProfileActivity.AllInOne((String)localObject, 1);; paramAdapterView = new ProfileActivity.AllInOne((String)localObject, 4))
    {
      paramAdapterView.g = 64;
      paramView = (TextView)paramView.findViewById(16908308);
      if (paramView != null) {
        paramAdapterView.h = paramView.getText().toString();
      }
      ProfileActivity.b(this, paramAdapterView);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getResources().getDimensionPixelSize(2131492923);
    setContentView(2130903371);
    setContentBackgroundResource(2130837687);
    c();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    runOnUiThread(new ekb(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ProgressDialog localProgressDialog = null;
    if (paramInt == 0) {
      localProgressDialog = DialogUtil.a(this, 2131365773);
    }
    return localProgressDialog;
  }
  
  protected void onDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_Ekj != null) {
      this.jdField_a_of_type_Ekj.b();
    }
    super.onDestroy();
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MayKnowManActivity
 * JD-Core Version:    0.7.0.1
 */