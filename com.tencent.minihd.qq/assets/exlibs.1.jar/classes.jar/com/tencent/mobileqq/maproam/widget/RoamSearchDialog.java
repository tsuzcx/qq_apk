package com.tencent.mobileqq.maproam.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import jft;
import jfu;
import jfv;
import jfw;
import jfz;
import jgb;

public class RoamSearchDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 10;
  public static final String a;
  public static final int b = 20000;
  public static final int c = 10000;
  public static final int d = 8192;
  public static final int e = 10;
  public static final int f = 20000;
  public static final int g = 10000;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 5;
  public long a;
  public Context a;
  public Button a;
  public EditText a;
  public ImageButton a;
  public TextView a;
  public QQAppInterface a;
  public RoamSearchDialog.OnRoamResultObserver a;
  public RoamSearchDialog.OnSearchResultItemClick a;
  public XListView a;
  public List a;
  public jgb a;
  public String b;
  public int k = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = RoamSearchDialog.class.getSimpleName();
  }
  
  public RoamSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "北京";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903373);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    b();
    c();
    d();
    e();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297285));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Jgb = new jgb(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Jgb);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new jft(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new jfu(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297286));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366465);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131369321);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new jfv(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    jfz localjfz = new jfz(this, null);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localjfz);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localjfz);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299465));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299461));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_Long = l;
      this.k = 1;
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_JavaLangString, 5, this.k);
    }
  }
  
  public void a(RoamSearchDialog.OnRoamResultObserver paramOnRoamResultObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = paramOnRoamResultObserver;
  }
  
  public void a(RoamSearchDialog.OnSearchResultItemClick paramOnSearchResultItemClick)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = paramOnSearchResultItemClick;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.a();
    if ((this.jdField_a_of_type_Jgb == null) || (localObject == null) || (localObject != this.jdField_a_of_type_Jgb) || (this.jdField_a_of_type_Jgb.getItemViewType(paramInt) == 1)) {}
    do
    {
      do
      {
        return;
        localObject = (LocationDetail)this.jdField_a_of_type_Jgb.getItem(paramInt);
      } while ((this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick == null) || (localObject == null));
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick.a(paramAdapterView, paramView, paramInt, (LocationDetail)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "current click location, lat = " + ((LocationDetail)localObject).jdField_a_of_type_Double + ", lon = " + ((LocationDetail)localObject).jdField_b_of_type_Double);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "search poi, currentKeyword = " + paramString1 + ", region = " + paramString2);
    }
    if (paramInt2 == 1)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_Jgb != null) {
        this.jdField_a_of_type_Jgb.notifyDataSetChanged();
      }
    }
    new jfw(this, paramString1, paramString2, paramInt1, paramInt2).start();
  }
  
  /* Error */
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 6
    //   3: aload_2
    //   4: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +7 -> 14
    //   10: ldc 64
    //   12: astore 6
    //   14: new 299	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 353
    //   24: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokestatic 359	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 361
    //   37: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 6
    //   42: invokestatic 359	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 363
    //   51: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_3
    //   55: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 368
    //   61: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 4
    //   66: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_1
    //   73: new 370	org/apache/http/params/BasicHttpParams
    //   76: dup
    //   77: invokespecial 371	org/apache/http/params/BasicHttpParams:<init>	()V
    //   80: astore_2
    //   81: aload_2
    //   82: ldc2_w 372
    //   85: invokestatic 379	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   88: aload_2
    //   89: new 381	org/apache/http/conn/params/ConnPerRouteBean
    //   92: dup
    //   93: bipush 10
    //   95: invokespecial 382	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   98: invokestatic 386	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   101: aload_2
    //   102: bipush 10
    //   104: invokestatic 390	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   107: aload_2
    //   108: sipush 10000
    //   111: invokestatic 395	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   114: aload_2
    //   115: sipush 20000
    //   118: invokestatic 398	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   121: aload_2
    //   122: iconst_1
    //   123: invokestatic 402	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   126: aload_2
    //   127: sipush 8192
    //   130: invokestatic 405	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   133: aload_2
    //   134: getstatic 411	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   137: invokestatic 417	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   140: aload_2
    //   141: ldc_w 419
    //   144: invokestatic 423	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   147: new 425	org/apache/http/impl/client/DefaultHttpClient
    //   150: dup
    //   151: aload_2
    //   152: invokespecial 428	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   155: astore_2
    //   156: aload_0
    //   157: getfield 72	com/tencent/mobileqq/maproam/widget/RoamSearchDialog:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   160: aload_2
    //   161: invokestatic 433	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   164: new 435	java/io/BufferedReader
    //   167: dup
    //   168: new 437	java/io/InputStreamReader
    //   171: dup
    //   172: aload_2
    //   173: new 439	org/apache/http/client/methods/HttpGet
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 441	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   181: invokeinterface 447 2 0
    //   186: invokeinterface 453 1 0
    //   191: invokeinterface 459 1 0
    //   196: invokespecial 462	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   199: invokespecial 465	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   202: astore 6
    //   204: ldc_w 467
    //   207: astore_1
    //   208: aload 6
    //   210: invokevirtual 470	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   213: astore 7
    //   215: aload_1
    //   216: astore_2
    //   217: aload 7
    //   219: ifnull +39 -> 258
    //   222: new 299	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   229: aload_1
    //   230: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 7
    //   235: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore_2
    //   242: aload_2
    //   243: astore_1
    //   244: goto -36 -> 208
    //   247: astore_2
    //   248: ldc_w 467
    //   251: astore_1
    //   252: aload_2
    //   253: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   256: aload_1
    //   257: astore_2
    //   258: new 475	org/json/JSONObject
    //   261: dup
    //   262: aload_2
    //   263: invokespecial 476	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   266: astore_2
    //   267: aload_2
    //   268: ldc_w 478
    //   271: invokevirtual 482	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   274: istore_3
    //   275: aload_2
    //   276: ldc_w 484
    //   279: invokevirtual 487	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 6
    //   284: new 489	android/os/Handler
    //   287: dup
    //   288: invokestatic 495	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   291: invokespecial 498	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   294: astore_1
    //   295: iload_3
    //   296: ifeq +64 -> 360
    //   299: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +41 -> 343
    //   305: getstatic 50	com/tencent/mobileqq/maproam/widget/RoamSearchDialog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: iconst_2
    //   309: new 299	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 500
    //   319: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: iload_3
    //   323: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 502
    //   329: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 6
    //   334: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_1
    //   344: new 504	jfx
    //   347: dup
    //   348: aload_0
    //   349: iload_3
    //   350: aload 6
    //   352: invokespecial 507	jfx:<init>	(Lcom/tencent/mobileqq/maproam/widget/RoamSearchDialog;ILjava/lang/String;)V
    //   355: invokevirtual 511	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   358: pop
    //   359: return
    //   360: aload_2
    //   361: ldc_w 513
    //   364: invokevirtual 482	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   367: istore 4
    //   369: aload_2
    //   370: ldc_w 515
    //   373: invokevirtual 519	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   376: astore_2
    //   377: new 58	java/util/ArrayList
    //   380: dup
    //   381: invokespecial 60	java/util/ArrayList:<init>	()V
    //   384: astore 6
    //   386: iconst_0
    //   387: istore_3
    //   388: aload_2
    //   389: invokevirtual 525	org/json/JSONArray:length	()I
    //   392: istore 5
    //   394: iload_3
    //   395: iload 5
    //   397: if_icmpge +201 -> 598
    //   400: aload_2
    //   401: iload_3
    //   402: invokevirtual 529	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   405: astore 8
    //   407: new 287	com/tencent/mobileqq/maproam/data/LocationDetail
    //   410: dup
    //   411: invokespecial 530	com/tencent/mobileqq/maproam/data/LocationDetail:<init>	()V
    //   414: astore 7
    //   416: aload 8
    //   418: ldc_w 532
    //   421: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   424: ifeq +16 -> 440
    //   427: aload 7
    //   429: aload 8
    //   431: ldc_w 532
    //   434: invokevirtual 487	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   437: putfield 537	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   440: aload 8
    //   442: ldc_w 539
    //   445: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   448: ifeq +16 -> 464
    //   451: aload 7
    //   453: aload 8
    //   455: ldc_w 539
    //   458: invokevirtual 487	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield 540	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   464: aload 8
    //   466: ldc_w 542
    //   469: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   472: ifeq +16 -> 488
    //   475: aload 7
    //   477: aload 8
    //   479: ldc_w 542
    //   482: invokevirtual 487	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   485: putfield 544	com/tencent/mobileqq/maproam/data/LocationDetail:c	Ljava/lang/String;
    //   488: aload 8
    //   490: ldc_w 546
    //   493: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   496: ifeq +16 -> 512
    //   499: aload 7
    //   501: aload 8
    //   503: ldc_w 546
    //   506: invokevirtual 487	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   509: putfield 548	com/tencent/mobileqq/maproam/data/LocationDetail:d	Ljava/lang/String;
    //   512: aload 8
    //   514: ldc_w 550
    //   517: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   520: ifeq +61 -> 581
    //   523: aload 8
    //   525: ldc_w 550
    //   528: invokevirtual 554	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   531: astore 8
    //   533: aload 8
    //   535: ldc_w 556
    //   538: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   541: ifeq +16 -> 557
    //   544: aload 7
    //   546: aload 8
    //   548: ldc_w 556
    //   551: invokevirtual 560	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   554: putfield 309	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_a_of_type_Double	D
    //   557: aload 8
    //   559: ldc_w 562
    //   562: invokevirtual 536	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   565: ifeq +16 -> 581
    //   568: aload 7
    //   570: aload 8
    //   572: ldc_w 562
    //   575: invokevirtual 560	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   578: putfield 316	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_b_of_type_Double	D
    //   581: aload 6
    //   583: aload 7
    //   585: invokeinterface 566 2 0
    //   590: pop
    //   591: iload_3
    //   592: iconst_1
    //   593: iadd
    //   594: istore_3
    //   595: goto -201 -> 394
    //   598: aload_1
    //   599: new 568	jfy
    //   602: dup
    //   603: aload_0
    //   604: aload 6
    //   606: iload 4
    //   608: invokespecial 571	jfy:<init>	(Lcom/tencent/mobileqq/maproam/widget/RoamSearchDialog;Ljava/util/List;I)V
    //   611: invokevirtual 511	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   614: pop
    //   615: return
    //   616: astore_1
    //   617: return
    //   618: astore_2
    //   619: goto -367 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	RoamSearchDialog
    //   0	622	1	paramString1	String
    //   0	622	2	paramString2	String
    //   0	622	3	paramInt1	int
    //   0	622	4	paramInt2	int
    //   392	6	5	m	int
    //   1	604	6	localObject1	Object
    //   213	371	7	localObject2	Object
    //   405	166	8	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   164	204	247	java/io/IOException
    //   258	295	616	org/json/JSONException
    //   299	343	616	org/json/JSONException
    //   343	359	616	org/json/JSONException
    //   360	386	616	org/json/JSONException
    //   388	394	616	org/json/JSONException
    //   400	440	616	org/json/JSONException
    //   440	464	616	org/json/JSONException
    //   464	488	616	org/json/JSONException
    //   488	512	616	org/json/JSONException
    //   512	557	616	org/json/JSONException
    //   557	581	616	org/json/JSONException
    //   581	591	616	org/json/JSONException
    //   598	615	616	org/json/JSONException
    //   208	215	618	java/io/IOException
    //   222	242	618	java/io/IOException
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Jgb != null) {
      this.jdField_a_of_type_Jgb.notifyDataSetChanged();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131299465: 
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.widget.RoamSearchDialog
 * JD-Core Version:    0.7.0.1
 */