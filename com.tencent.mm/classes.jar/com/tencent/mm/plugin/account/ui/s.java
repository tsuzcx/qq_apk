package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.regex.Pattern;

public final class s
  extends ContentObserver
{
  private final Context context;
  private ContentResolver fiK;
  private final String[] fiZ;
  private final s.a fsV;
  private Pattern fsW = Pattern.compile("\\d{4,8}");
  
  public s(Context paramContext, s.a parama)
  {
    super(ah.fetchFreeHandler());
    if ((paramContext == null) || (parama == null)) {
      throw new NullPointerException("SmsContentObserver Construction");
    }
    this.context = paramContext;
    this.fiZ = paramContext.getResources().getStringArray(q.b.sms_content);
    this.fsV = parama;
  }
  
  /* Error */
  public final void Xt()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 75
    //   5: invokestatic 81	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   8: astore 8
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 46	com/tencent/mm/plugin/account/ui/s:context	Landroid/content/Context;
    //   15: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: putfield 87	com/tencent/mm/plugin/account/ui/s:fiK	Landroid/content/ContentResolver;
    //   21: ldc 89
    //   23: astore 6
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: aload_0
    //   29: getfield 66	com/tencent/mm/plugin/account/ui/s:fiZ	[Ljava/lang/String;
    //   32: arraylength
    //   33: if_icmpge +96 -> 129
    //   36: iload_1
    //   37: aload_0
    //   38: getfield 66	com/tencent/mm/plugin/account/ui/s:fiZ	[Ljava/lang/String;
    //   41: arraylength
    //   42: iconst_1
    //   43: isub
    //   44: if_icmpne +46 -> 90
    //   47: new 91	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   54: aload 6
    //   56: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 99
    //   61: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 66	com/tencent/mm/plugin/account/ui/s:fiZ	[Ljava/lang/String;
    //   68: iload_1
    //   69: aaload
    //   70: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 101
    //   75: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 6
    //   83: iload_1
    //   84: iconst_1
    //   85: iadd
    //   86: istore_1
    //   87: goto -60 -> 27
    //   90: new 91	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   97: aload 6
    //   99: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 107
    //   104: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 66	com/tencent/mm/plugin/account/ui/s:fiZ	[Ljava/lang/String;
    //   111: iload_1
    //   112: aaload
    //   113: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 109
    //   118: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 6
    //   126: goto -43 -> 83
    //   129: new 91	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   136: aload 6
    //   138: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 111
    //   143: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   149: ldc2_w 118
    //   152: lsub
    //   153: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: ldc 124
    //   158: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 6
    //   166: ldc 126
    //   168: new 91	java/lang/StringBuilder
    //   171: dup
    //   172: ldc 128
    //   174: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: aload 6
    //   179: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 135	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 6
    //   190: ifnull +13 -> 203
    //   193: aload 6
    //   195: ldc 137
    //   197: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq +4 -> 204
    //   203: return
    //   204: aload_0
    //   205: getfield 87	com/tencent/mm/plugin/account/ui/s:fiK	Landroid/content/ContentResolver;
    //   208: aload 8
    //   210: iconst_3
    //   211: anewarray 139	java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: ldc 145
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: ldc 147
    //   223: aastore
    //   224: dup
    //   225: iconst_2
    //   226: ldc 149
    //   228: aastore
    //   229: aload 6
    //   231: aconst_null
    //   232: aconst_null
    //   233: invokevirtual 155	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   236: astore 6
    //   238: iconst_m1
    //   239: istore_1
    //   240: lconst_0
    //   241: lstore_2
    //   242: aload 6
    //   244: invokeinterface 161 1 0
    //   249: ifeq +34 -> 283
    //   252: aload 6
    //   254: iconst_2
    //   255: invokeinterface 165 2 0
    //   260: lstore 4
    //   262: lload 4
    //   264: lload_2
    //   265: lcmp
    //   266: ifle +203 -> 469
    //   269: aload 6
    //   271: invokeinterface 169 1 0
    //   276: istore_1
    //   277: lload 4
    //   279: lstore_2
    //   280: goto +189 -> 469
    //   283: iload_1
    //   284: iflt +90 -> 374
    //   287: aload 6
    //   289: iload_1
    //   290: invokeinterface 173 2 0
    //   295: pop
    //   296: aload 6
    //   298: aload 6
    //   300: ldc 145
    //   302: invokeinterface 177 2 0
    //   307: invokeinterface 181 2 0
    //   312: astore 8
    //   314: aload_0
    //   315: getfield 37	com/tencent/mm/plugin/account/ui/s:fsW	Ljava/util/regex/Pattern;
    //   318: aload 8
    //   320: invokevirtual 185	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   323: astore 8
    //   325: aload 8
    //   327: invokevirtual 190	java/util/regex/Matcher:find	()Z
    //   330: ifeq +10 -> 340
    //   333: aload 8
    //   335: invokevirtual 193	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   338: astore 7
    //   340: aload_0
    //   341: getfield 68	com/tencent/mm/plugin/account/ui/s:fsV	Lcom/tencent/mm/plugin/account/ui/s$a;
    //   344: aload 7
    //   346: invokeinterface 196 2 0
    //   351: aload 6
    //   353: ifnull -150 -> 203
    //   356: aload 6
    //   358: invokeinterface 199 1 0
    //   363: ifne -160 -> 203
    //   366: aload 6
    //   368: invokeinterface 202 1 0
    //   373: return
    //   374: aload_0
    //   375: getfield 68	com/tencent/mm/plugin/account/ui/s:fsV	Lcom/tencent/mm/plugin/account/ui/s$a;
    //   378: invokeinterface 205 1 0
    //   383: goto -32 -> 351
    //   386: astore 7
    //   388: ldc 126
    //   390: aload 7
    //   392: invokevirtual 206	java/lang/Exception:toString	()Ljava/lang/String;
    //   395: invokestatic 209	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload 6
    //   400: ifnull -197 -> 203
    //   403: aload 6
    //   405: invokeinterface 199 1 0
    //   410: ifne -207 -> 203
    //   413: aload 6
    //   415: invokeinterface 202 1 0
    //   420: return
    //   421: astore 7
    //   423: aconst_null
    //   424: astore 6
    //   426: aload 6
    //   428: ifnull +20 -> 448
    //   431: aload 6
    //   433: invokeinterface 199 1 0
    //   438: ifne +10 -> 448
    //   441: aload 6
    //   443: invokeinterface 202 1 0
    //   448: aload 7
    //   450: athrow
    //   451: astore 7
    //   453: goto -27 -> 426
    //   456: astore 7
    //   458: goto -32 -> 426
    //   461: astore 7
    //   463: aconst_null
    //   464: astore 6
    //   466: goto -78 -> 388
    //   469: goto -227 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	s
    //   26	264	1	i	int
    //   241	39	2	l1	long
    //   260	18	4	l2	long
    //   23	442	6	localObject1	Object
    //   1	344	7	str	String
    //   386	5	7	localException1	java.lang.Exception
    //   421	28	7	localObject2	Object
    //   451	1	7	localObject3	Object
    //   456	1	7	localObject4	Object
    //   461	1	7	localException2	java.lang.Exception
    //   8	326	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   242	262	386	java/lang/Exception
    //   269	277	386	java/lang/Exception
    //   287	325	386	java/lang/Exception
    //   325	340	386	java/lang/Exception
    //   340	351	386	java/lang/Exception
    //   374	383	386	java/lang/Exception
    //   204	238	421	finally
    //   242	262	451	finally
    //   269	277	451	finally
    //   287	325	451	finally
    //   325	340	451	finally
    //   340	351	451	finally
    //   374	383	451	finally
    //   388	398	456	finally
    //   204	238	461	java/lang/Exception
  }
  
  public final void Yx()
  {
    this.context.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
  }
  
  public final void Yy()
  {
    this.context.getContentResolver().unregisterContentObserver(this);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if ((this.context instanceof Activity))
    {
      paramBoolean = a.a((Activity)this.context, "android.permission.READ_SMS", 128, "", "");
      y.i("MicroMsg.SmsContentObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb(), this.context });
      if (!paramBoolean) {
        return;
      }
    }
    Xt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.s
 * JD-Core Version:    0.7.0.1
 */