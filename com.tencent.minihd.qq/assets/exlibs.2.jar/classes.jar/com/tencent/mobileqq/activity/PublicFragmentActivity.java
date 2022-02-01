package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class PublicFragmentActivity
  extends FragmentActivity
{
  private static ArrayMap jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  public static final String a = "public_fragment_class";
  public static final String b = "public_fragment_window_feature";
  private static final String c = "PublicFragmentActivity";
  private PublicBaseFragment jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  
  public static void a(Activity paramActivity, Intent paramIntent, Class paramClass, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Activity paramActivity, Class paramClass, int paramInt)
  {
    a(paramActivity, null, paramClass, paramInt);
  }
  
  /* Error */
  private static void a(Context paramContext)
  {
    // Byte code:
    //   0: new 37	android/support/v4/util/ArrayMap
    //   3: dup
    //   4: invokespecial 38	android/support/v4/util/ArrayMap:<init>	()V
    //   7: putstatic 40	com/tencent/mobileqq/activity/PublicFragmentActivity:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   10: aload_0
    //   11: invokevirtual 46	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ldc 48
    //   18: invokevirtual 54	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_0
    //   22: aload_0
    //   23: astore_3
    //   24: invokestatic 60	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   27: astore 12
    //   29: aload_0
    //   30: astore_3
    //   31: aload 12
    //   33: aload_0
    //   34: ldc 62
    //   36: invokeinterface 68 3 0
    //   41: aload_0
    //   42: astore_3
    //   43: aload 12
    //   45: invokeinterface 72 1 0
    //   50: istore_1
    //   51: aconst_null
    //   52: astore 8
    //   54: aconst_null
    //   55: astore 9
    //   57: aconst_null
    //   58: astore 10
    //   60: aconst_null
    //   61: astore 11
    //   63: goto +523 -> 586
    //   66: aload_0
    //   67: astore_3
    //   68: aload 12
    //   70: invokeinterface 75 1 0
    //   75: istore_1
    //   76: aload 4
    //   78: astore 8
    //   80: aload 5
    //   82: astore 9
    //   84: aload 6
    //   86: astore 10
    //   88: aload 7
    //   90: astore 11
    //   92: goto +494 -> 586
    //   95: aload_0
    //   96: astore_3
    //   97: aload 12
    //   99: invokeinterface 79 1 0
    //   104: astore 13
    //   106: aload_0
    //   107: astore_3
    //   108: ldc 81
    //   110: aload 13
    //   112: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +18 -> 133
    //   118: aconst_null
    //   119: astore 4
    //   121: aconst_null
    //   122: astore 5
    //   124: aconst_null
    //   125: astore 6
    //   127: aconst_null
    //   128: astore 7
    //   130: goto -64 -> 66
    //   133: aload_0
    //   134: astore_3
    //   135: ldc 89
    //   137: aload 13
    //   139: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq +39 -> 181
    //   145: aload_0
    //   146: astore_3
    //   147: aload 12
    //   149: invokeinterface 75 1 0
    //   154: pop
    //   155: aload_0
    //   156: astore_3
    //   157: aload 12
    //   159: invokeinterface 92 1 0
    //   164: astore 7
    //   166: aload 8
    //   168: astore 4
    //   170: aload 9
    //   172: astore 5
    //   174: aload 10
    //   176: astore 6
    //   178: goto -112 -> 66
    //   181: aload_0
    //   182: astore_3
    //   183: ldc 94
    //   185: aload 13
    //   187: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +39 -> 229
    //   193: aload_0
    //   194: astore_3
    //   195: aload 12
    //   197: invokeinterface 75 1 0
    //   202: pop
    //   203: aload_0
    //   204: astore_3
    //   205: aload 12
    //   207: invokeinterface 92 1 0
    //   212: astore 6
    //   214: aload 8
    //   216: astore 4
    //   218: aload 9
    //   220: astore 5
    //   222: aload 11
    //   224: astore 7
    //   226: goto -160 -> 66
    //   229: aload_0
    //   230: astore_3
    //   231: ldc 96
    //   233: aload 13
    //   235: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +39 -> 277
    //   241: aload_0
    //   242: astore_3
    //   243: aload 12
    //   245: invokeinterface 75 1 0
    //   250: pop
    //   251: aload_0
    //   252: astore_3
    //   253: aload 12
    //   255: invokeinterface 92 1 0
    //   260: astore 5
    //   262: aload 8
    //   264: astore 4
    //   266: aload 10
    //   268: astore 6
    //   270: aload 11
    //   272: astore 7
    //   274: goto -208 -> 66
    //   277: aload 8
    //   279: astore 4
    //   281: aload 9
    //   283: astore 5
    //   285: aload 10
    //   287: astore 6
    //   289: aload 11
    //   291: astore 7
    //   293: aload_0
    //   294: astore_3
    //   295: ldc 98
    //   297: aload 13
    //   299: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq -236 -> 66
    //   305: aload_0
    //   306: astore_3
    //   307: aload 12
    //   309: invokeinterface 75 1 0
    //   314: pop
    //   315: aload_0
    //   316: astore_3
    //   317: aload 12
    //   319: invokeinterface 92 1 0
    //   324: astore 4
    //   326: aload 9
    //   328: astore 5
    //   330: aload 10
    //   332: astore 6
    //   334: aload 11
    //   336: astore 7
    //   338: goto -272 -> 66
    //   341: aload 8
    //   343: astore 4
    //   345: aload 9
    //   347: astore 5
    //   349: aload 10
    //   351: astore 6
    //   353: aload 11
    //   355: astore 7
    //   357: aload_0
    //   358: astore_3
    //   359: ldc 81
    //   361: aload 12
    //   363: invokeinterface 79 1 0
    //   368: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifeq -305 -> 66
    //   374: aload_0
    //   375: astore_3
    //   376: aload 11
    //   378: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifeq +46 -> 427
    //   384: aload_0
    //   385: astore_3
    //   386: ldc 15
    //   388: iconst_2
    //   389: ldc 106
    //   391: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload 8
    //   396: astore 4
    //   398: aload 9
    //   400: astore 5
    //   402: aload 10
    //   404: astore 6
    //   406: aload 11
    //   408: astore 7
    //   410: goto -344 -> 66
    //   413: astore 4
    //   415: aload_0
    //   416: astore_3
    //   417: aload 4
    //   419: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   422: aload_0
    //   423: invokestatic 120	com/tencent/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   426: return
    //   427: aload_0
    //   428: astore_3
    //   429: getstatic 40	com/tencent/mobileqq/activity/PublicFragmentActivity:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   432: aload 11
    //   434: invokevirtual 123	android/support/v4/util/ArrayMap:containsKey	(Ljava/lang/Object;)Z
    //   437: ifeq +46 -> 483
    //   440: aload_0
    //   441: astore_3
    //   442: ldc 15
    //   444: iconst_2
    //   445: ldc 125
    //   447: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 8
    //   452: astore 4
    //   454: aload 9
    //   456: astore 5
    //   458: aload 10
    //   460: astore 6
    //   462: aload 11
    //   464: astore 7
    //   466: goto -400 -> 66
    //   469: astore 4
    //   471: aload_0
    //   472: astore_3
    //   473: aload 4
    //   475: invokevirtual 126	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   478: aload_0
    //   479: invokestatic 120	com/tencent/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   482: return
    //   483: aload_0
    //   484: astore_3
    //   485: aload 10
    //   487: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   490: ifne +66 -> 556
    //   493: aload_0
    //   494: astore_3
    //   495: aload 9
    //   497: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   500: ifne +56 -> 556
    //   503: aload_0
    //   504: astore_3
    //   505: aload 8
    //   507: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   510: ifne +46 -> 556
    //   513: iconst_1
    //   514: istore_2
    //   515: aload_0
    //   516: astore_3
    //   517: getstatic 40	com/tencent/mobileqq/activity/PublicFragmentActivity:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   520: aload 11
    //   522: iload_2
    //   523: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   526: invokevirtual 136	android/support/v4/util/ArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   529: pop
    //   530: aload 8
    //   532: astore 4
    //   534: aload 9
    //   536: astore 5
    //   538: aload 10
    //   540: astore 6
    //   542: aload 11
    //   544: astore 7
    //   546: goto -480 -> 66
    //   549: astore_0
    //   550: aload_3
    //   551: invokestatic 120	com/tencent/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   554: aload_0
    //   555: athrow
    //   556: iconst_0
    //   557: istore_2
    //   558: goto -43 -> 515
    //   561: aload_0
    //   562: invokestatic 120	com/tencent/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   565: return
    //   566: astore_0
    //   567: aconst_null
    //   568: astore_3
    //   569: goto -19 -> 550
    //   572: astore 4
    //   574: aconst_null
    //   575: astore_0
    //   576: goto -105 -> 471
    //   579: astore 4
    //   581: aconst_null
    //   582: astore_0
    //   583: goto -168 -> 415
    //   586: iload_1
    //   587: iconst_1
    //   588: if_icmpeq -27 -> 561
    //   591: iload_1
    //   592: tableswitch	default:+24 -> 616, 2:+-497->95, 3:+-251->341
    //   617: iconst_5
    //   618: astore 4
    //   620: aload 9
    //   622: astore 5
    //   624: aload 10
    //   626: astore 6
    //   628: aload 11
    //   630: astore 7
    //   632: goto -566 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	paramContext	Context
    //   50	542	1	i	int
    //   514	44	2	bool	boolean
    //   23	546	3	localContext	Context
    //   76	321	4	localObject1	Object
    //   413	5	4	localIOException1	java.io.IOException
    //   452	1	4	localObject2	Object
    //   469	5	4	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   532	1	4	localObject3	Object
    //   572	1	4	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   579	1	4	localIOException2	java.io.IOException
    //   618	1	4	localObject4	Object
    //   80	543	5	localObject5	Object
    //   84	543	6	localObject6	Object
    //   88	543	7	localObject7	Object
    //   52	565	8	localObject8	Object
    //   55	566	9	localObject9	Object
    //   58	567	10	localObject10	Object
    //   61	568	11	localObject11	Object
    //   27	335	12	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   104	194	13	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	413	java/io/IOException
    //   31	41	413	java/io/IOException
    //   43	51	413	java/io/IOException
    //   68	76	413	java/io/IOException
    //   97	106	413	java/io/IOException
    //   108	118	413	java/io/IOException
    //   135	145	413	java/io/IOException
    //   147	155	413	java/io/IOException
    //   157	166	413	java/io/IOException
    //   183	193	413	java/io/IOException
    //   195	203	413	java/io/IOException
    //   205	214	413	java/io/IOException
    //   231	241	413	java/io/IOException
    //   243	251	413	java/io/IOException
    //   253	262	413	java/io/IOException
    //   295	305	413	java/io/IOException
    //   307	315	413	java/io/IOException
    //   317	326	413	java/io/IOException
    //   359	374	413	java/io/IOException
    //   376	384	413	java/io/IOException
    //   386	394	413	java/io/IOException
    //   429	440	413	java/io/IOException
    //   442	450	413	java/io/IOException
    //   485	493	413	java/io/IOException
    //   495	503	413	java/io/IOException
    //   505	513	413	java/io/IOException
    //   517	530	413	java/io/IOException
    //   24	29	469	org/xmlpull/v1/XmlPullParserException
    //   31	41	469	org/xmlpull/v1/XmlPullParserException
    //   43	51	469	org/xmlpull/v1/XmlPullParserException
    //   68	76	469	org/xmlpull/v1/XmlPullParserException
    //   97	106	469	org/xmlpull/v1/XmlPullParserException
    //   108	118	469	org/xmlpull/v1/XmlPullParserException
    //   135	145	469	org/xmlpull/v1/XmlPullParserException
    //   147	155	469	org/xmlpull/v1/XmlPullParserException
    //   157	166	469	org/xmlpull/v1/XmlPullParserException
    //   183	193	469	org/xmlpull/v1/XmlPullParserException
    //   195	203	469	org/xmlpull/v1/XmlPullParserException
    //   205	214	469	org/xmlpull/v1/XmlPullParserException
    //   231	241	469	org/xmlpull/v1/XmlPullParserException
    //   243	251	469	org/xmlpull/v1/XmlPullParserException
    //   253	262	469	org/xmlpull/v1/XmlPullParserException
    //   295	305	469	org/xmlpull/v1/XmlPullParserException
    //   307	315	469	org/xmlpull/v1/XmlPullParserException
    //   317	326	469	org/xmlpull/v1/XmlPullParserException
    //   359	374	469	org/xmlpull/v1/XmlPullParserException
    //   376	384	469	org/xmlpull/v1/XmlPullParserException
    //   386	394	469	org/xmlpull/v1/XmlPullParserException
    //   429	440	469	org/xmlpull/v1/XmlPullParserException
    //   442	450	469	org/xmlpull/v1/XmlPullParserException
    //   485	493	469	org/xmlpull/v1/XmlPullParserException
    //   495	503	469	org/xmlpull/v1/XmlPullParserException
    //   505	513	469	org/xmlpull/v1/XmlPullParserException
    //   517	530	469	org/xmlpull/v1/XmlPullParserException
    //   24	29	549	finally
    //   31	41	549	finally
    //   43	51	549	finally
    //   68	76	549	finally
    //   97	106	549	finally
    //   108	118	549	finally
    //   135	145	549	finally
    //   147	155	549	finally
    //   157	166	549	finally
    //   183	193	549	finally
    //   195	203	549	finally
    //   205	214	549	finally
    //   231	241	549	finally
    //   243	251	549	finally
    //   253	262	549	finally
    //   295	305	549	finally
    //   307	315	549	finally
    //   317	326	549	finally
    //   359	374	549	finally
    //   376	384	549	finally
    //   386	394	549	finally
    //   417	422	549	finally
    //   429	440	549	finally
    //   442	450	549	finally
    //   473	478	549	finally
    //   485	493	549	finally
    //   495	503	549	finally
    //   505	513	549	finally
    //   517	530	549	finally
    //   15	22	566	finally
    //   15	22	572	org/xmlpull/v1/XmlPullParserException
    //   15	22	579	java/io/IOException
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class paramClass)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivity.class, paramClass);
  }
  
  public static void a(Context paramContext, Class paramClass)
  {
    a(paramContext, null, paramClass);
  }
  
  private static void a(Context paramContext, String paramString) {}
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {
      try
      {
        Object localObject2 = Class.forName("android.support.v4.app.FragmentManagerState");
        paramBundle = Class.forName("android.support.v4.app.FragmentState");
        if (((Class)localObject2).isInstance(localObject1))
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mActive");
          if (!((Field)localObject2).isAccessible()) {
            ((Field)localObject2).setAccessible(true);
          }
          if (((Field)localObject2).getType().isArray())
          {
            localObject1 = ((Field)localObject2).get(localObject1);
            int j = Array.getLength(localObject1);
            int i = 0;
            while (i < j)
            {
              localObject2 = Array.get(localObject1, i);
              if ((localObject2 != null) && (paramBundle.isInstance(localObject2)))
              {
                Field localField = paramBundle.getDeclaredField("mArguments");
                if (!localField.isAccessible()) {
                  localField.setAccessible(true);
                }
                localObject2 = localField.get(localObject2);
                if ((localObject2 != null) && ((localObject2 instanceof Bundle))) {
                  ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
                }
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("PublicFragmentActivity", 2, "Patch error");
      }
    }
  }
  
  public static void a(Fragment paramFragment, Intent paramIntent, Class paramClass, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramFragment, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Fragment paramFragment, Class paramClass, int paramInt)
  {
    a(paramFragment, null, paramClass, paramInt);
  }
  
  private PublicBaseFragment b()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    a(this, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PublicFragmentActivity", 2, "creating fragment " + (String)localObject);
    }
    try
    {
      localObject = (PublicBaseFragment)Class.forName((String)localObject).newInstance();
      ((PublicBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("PublicFragmentActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  public PublicBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.f()) && (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.a(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment = b();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.a(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      a(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2130903064);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131296648, this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment);
    paramBundle.commit();
    return true;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.a(paramIntent);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.f();
    }
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.g();
    }
  }
  
  protected boolean isWrapContent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.e();
    }
    return super.isWrapContent();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.e();
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.d();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.d();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.a(paramBoolean);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      str1 = str2 + "#" + this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.getClass().getName() + "@" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment.hashCode());
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (getIntent() == null);
      str1 = str2;
    } while (getIntent().getStringExtra("public_fragment_class") == null);
    return str2 + "#" + getIntent().getStringExtra("public_fragment_class");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */