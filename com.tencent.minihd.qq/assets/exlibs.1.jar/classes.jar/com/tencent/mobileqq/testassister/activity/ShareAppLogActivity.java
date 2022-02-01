package com.tencent.mobileqq.testassister.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Time;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.Switch;
import com.tencent.widget.TCWDatePickerDialogHelper;
import jyu;
import jyv;
import jyw;
import jyz;
import jza;
import jzb;

public class ShareAppLogActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new jyu(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new jyv(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = new jyw(this);
  private ShareAppLogHelper jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  private int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, ShareAppLogActivity.class);
  }
  
  private String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.year + "-" + (localTime.month + 1) + "-" + localTime.monthDay;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jyz(this));
  }
  
  private void a(TextView paramTextView)
  {
    Time localTime = ShareAppLogHelper.a(paramTextView.getEditableText().toString(), "-");
    if (localTime == null) {
      return;
    }
    int i = localTime.year;
    int j = localTime.month;
    int k = localTime.monthDay;
    try
    {
      TCWDatePickerDialogHelper.a(this, i, j + 1, k, new jzb(this, paramTextView));
      return;
    }
    catch (Exception paramTextView) {}
  }
  
  private void a(String paramString)
  {
    paramString = new FileInfo(paramString);
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramString);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10000);
    localForwardFileInfo.a(paramString.d());
    localForwardFileInfo.d(paramString.e());
    localForwardFileInfo.d(paramString.a());
    a(localForwardFileInfo);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jza(this));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  public void a(ForwardFileInfo paramForwardFileInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putParcelable("fileinfo", paramForwardFileInfo);
    localBundle.putBoolean("not_forward", true);
    Intent localIntent = new Intent(this, ForwardRecentActivity.class);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_text", paramForwardFileInfo.d());
    localIntent.putExtra("forward_type", 0);
    startActivityForResult(localIntent, 103);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while ((paramIntent == null) || (paramIntent.getExtras() == null));
    a(paramIntent.getExtras());
  }
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 256	android/view/View:getId	()I
    //   4: lookupswitch	default:+44->48, 2131300517:+283->287, 2131300521:+292->296, 2131300525:+45->49, 2131300527:+301->305
    //   49: aload_0
    //   50: getfield 258	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   53: invokevirtual 108	android/widget/TextView:getEditableText	()Landroid/text/Editable;
    //   56: invokevirtual 111	java/lang/Object:toString	()Ljava/lang/String;
    //   59: astore 8
    //   61: aload_0
    //   62: getfield 260	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   65: invokevirtual 108	android/widget/TextView:getEditableText	()Landroid/text/Editable;
    //   68: invokevirtual 111	java/lang/Object:toString	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 262	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   76: invokevirtual 265	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   79: invokevirtual 111	java/lang/Object:toString	()Ljava/lang/String;
    //   82: invokestatic 271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   85: istore_2
    //   86: aload_0
    //   87: getfield 273	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   90: invokevirtual 265	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   93: invokevirtual 111	java/lang/Object:toString	()Ljava/lang/String;
    //   96: invokestatic 271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: istore_3
    //   100: iload_2
    //   101: iflt +19 -> 120
    //   104: iload_2
    //   105: bipush 24
    //   107: if_icmpge +13 -> 120
    //   110: iload_3
    //   111: iflt +9 -> 120
    //   114: iload_3
    //   115: bipush 24
    //   117: if_icmplt +19 -> 136
    //   120: aload_0
    //   121: invokevirtual 277	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   124: ldc_w 279
    //   127: iconst_0
    //   128: invokestatic 284	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   131: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   134: pop
    //   135: return
    //   136: new 67	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   143: aload 8
    //   145: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 77
    //   150: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload_2
    //   154: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: ldc 77
    //   162: invokestatic 116	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/text/format/Time;
    //   165: astore 8
    //   167: new 67	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   174: aload_1
    //   175: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 77
    //   180: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload_3
    //   184: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: ldc 77
    //   192: invokestatic 116	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/text/format/Time;
    //   195: astore_1
    //   196: aload 8
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: ifnonnull +19 -> 221
    //   205: aload_0
    //   206: invokevirtual 277	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   209: ldc_w 289
    //   212: iconst_0
    //   213: invokestatic 284	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   216: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   219: pop
    //   220: return
    //   221: aload_1
    //   222: aload 8
    //   224: invokevirtual 293	android/text/format/Time:before	(Landroid/text/format/Time;)Z
    //   227: ifeq +19 -> 246
    //   230: aload_0
    //   231: invokevirtual 277	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   234: ldc_w 279
    //   237: iconst_0
    //   238: invokestatic 284	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   241: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   244: pop
    //   245: return
    //   246: aload_0
    //   247: getfield 60	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper	Lcom/tencent/mobileqq/testassister/ShareAppLogHelper;
    //   250: aload 8
    //   252: aload_1
    //   253: aload_0
    //   254: getfield 295	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_ComTencentWidgetSwitch	Lcom/tencent/widget/Switch;
    //   257: invokevirtual 301	com/tencent/widget/Switch:isChecked	()Z
    //   260: invokevirtual 304	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Landroid/text/format/Time;Landroid/text/format/Time;Z)Z
    //   263: ifeq +8 -> 271
    //   266: aload_0
    //   267: invokespecial 179	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	()V
    //   270: return
    //   271: aload_0
    //   272: invokevirtual 277	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   275: ldc_w 306
    //   278: iconst_0
    //   279: invokestatic 284	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   282: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   285: pop
    //   286: return
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 258	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   292: invokespecial 308	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Landroid/widget/TextView;)V
    //   295: return
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 260	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   301: invokespecial 308	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Landroid/widget/TextView;)V
    //   304: return
    //   305: new 310	java/io/File
    //   308: dup
    //   309: new 67	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   316: invokestatic 316	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   319: invokevirtual 319	java/io/File:getPath	()Ljava/lang/String;
    //   322: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 321
    //   328: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   337: astore 10
    //   339: aconst_null
    //   340: astore 9
    //   342: aconst_null
    //   343: astore_1
    //   344: aload 9
    //   346: astore 8
    //   348: aload 10
    //   350: invokevirtual 325	java/io/File:exists	()Z
    //   353: ifeq +133 -> 486
    //   356: aload 9
    //   358: astore 8
    //   360: aload 10
    //   362: invokevirtual 328	java/io/File:isDirectory	()Z
    //   365: ifeq +121 -> 486
    //   368: aload 10
    //   370: invokevirtual 332	java/io/File:listFiles	()[Ljava/io/File;
    //   373: astore 10
    //   375: aload 9
    //   377: astore 8
    //   379: aload 10
    //   381: ifnull +105 -> 486
    //   384: lconst_0
    //   385: lstore 4
    //   387: iconst_0
    //   388: istore_2
    //   389: aload_1
    //   390: astore 8
    //   392: iload_2
    //   393: aload 10
    //   395: arraylength
    //   396: if_icmpge +90 -> 486
    //   399: lload 4
    //   401: lstore 6
    //   403: aload_1
    //   404: astore 8
    //   406: aload 10
    //   408: iload_2
    //   409: aaload
    //   410: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   413: ldc_w 337
    //   416: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   419: ifeq +97 -> 516
    //   422: lload 4
    //   424: lstore 6
    //   426: aload_1
    //   427: astore 8
    //   429: aload 10
    //   431: iload_2
    //   432: aaload
    //   433: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   436: ldc_w 345
    //   439: invokevirtual 348	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   442: ifeq +74 -> 516
    //   445: lload 4
    //   447: lstore 6
    //   449: aload_1
    //   450: astore 8
    //   452: aload 10
    //   454: iload_2
    //   455: aaload
    //   456: invokevirtual 351	java/io/File:lastModified	()J
    //   459: lload 4
    //   461: lcmp
    //   462: ifle +54 -> 516
    //   465: aload 10
    //   467: iload_2
    //   468: aaload
    //   469: invokevirtual 319	java/io/File:getPath	()Ljava/lang/String;
    //   472: astore 8
    //   474: aload 10
    //   476: iload_2
    //   477: aaload
    //   478: invokevirtual 351	java/io/File:lastModified	()J
    //   481: lstore 6
    //   483: goto +33 -> 516
    //   486: aload 8
    //   488: ifnull +10 -> 498
    //   491: aload_0
    //   492: aload 8
    //   494: invokespecial 132	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Ljava/lang/String;)V
    //   497: return
    //   498: aload_0
    //   499: invokevirtual 277	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   502: ldc_w 353
    //   505: iconst_0
    //   506: invokestatic 284	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   509: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   512: pop
    //   513: return
    //   514: astore_1
    //   515: return
    //   516: iload_2
    //   517: iconst_1
    //   518: iadd
    //   519: istore_2
    //   520: lload 6
    //   522: lstore 4
    //   524: aload 8
    //   526: astore_1
    //   527: goto -138 -> 389
    //   530: astore_1
    //   531: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	ShareAppLogActivity
    //   0	532	1	paramView	android.view.View
    //   85	435	2	i	int
    //   99	85	3	j	int
    //   385	138	4	l1	long
    //   401	120	6	l2	long
    //   59	466	8	localObject1	Object
    //   340	36	9	localObject2	Object
    //   337	138	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	100	514	java/lang/Exception
    //   305	339	530	java/lang/Exception
    //   348	356	530	java/lang/Exception
    //   360	375	530	java/lang/Exception
    //   392	399	530	java/lang/Exception
    //   406	422	530	java/lang/Exception
    //   429	445	530	java/lang/Exception
    //   452	483	530	java/lang/Exception
    //   491	497	530	java/lang/Exception
    //   498	513	530	java/lang/Exception
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904020);
    setTitle(2131368061);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300517));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300521));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300516));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300520));
    this.jdField_a_of_type_AndroidWidgetTextView.setInputType(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setInputType(4);
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper = new ShareAppLogHelper(getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(System.currentTimeMillis() - 7200000L));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(System.currentTimeMillis()));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.format("%02d", new Object[] { Integer.valueOf(a(System.currentTimeMillis() - 7200000L)) }));
    this.jdField_b_of_type_AndroidWidgetEditText.setText(String.format("%02d", new Object[] { Integer.valueOf(a(System.currentTimeMillis())) }));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131300523));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300525));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300527));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(null);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.activity.ShareAppLogActivity
 * JD-Core Version:    0.7.0.1
 */