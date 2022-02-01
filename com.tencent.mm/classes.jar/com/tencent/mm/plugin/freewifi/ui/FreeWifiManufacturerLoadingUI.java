package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class FreeWifiManufacturerLoadingUI
  extends MMActivity
{
  private String bssid;
  private au cLS;
  private String ssid;
  private ImageView stH;
  private TextView stI;
  private Button stJ;
  private final int stK;
  private final int stL;
  private final int stM;
  private int[] stN;
  ao stO;
  ao stP;
  
  public FreeWifiManufacturerLoadingUI()
  {
    AppMethodBeat.i(25077);
    this.stK = 1;
    this.stL = 2;
    this.stM = 3;
    this.stN = new int[] { 2131232429, 2131232430, 2131232431, 2131232432, 2131232433 };
    this.stO = new ao()
    {
      int i = 0;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25067);
        if (paramAnonymousMessage.what == 1)
        {
          if (this.i >= FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this).length) {
            this.i = 0;
          }
          FreeWifiManufacturerLoadingUI.b(FreeWifiManufacturerLoadingUI.this).setImageResource(FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this)[this.i]);
          this.i += 1;
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(25067);
          return;
          if (paramAnonymousMessage.what == 2) {
            FreeWifiManufacturerLoadingUI.b(FreeWifiManufacturerLoadingUI.this).setImageResource(FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this)[(FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this).length - 1)]);
          } else if ((paramAnonymousMessage.what == 3) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof String))) {
            FreeWifiManufacturerLoadingUI.c(FreeWifiManufacturerLoadingUI.this).setText(paramAnonymousMessage.obj.toString());
          }
        }
      }
    };
    this.stP = new ao();
    AppMethodBeat.o(25077);
  }
  
  private void afD(final String paramString)
  {
    AppMethodBeat.i(25082);
    j.cJn().cIW().post(new Runnable()
    {
      private int stS = 0;
      private final int stT = 5;
      
      private void cKc()
      {
        AppMethodBeat.i(25073);
        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
        this.stS += 1;
        try
        {
          Thread.sleep(2000L);
          cKd();
          AppMethodBeat.o(25073);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ac.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + localInterruptedException.getMessage());
          }
        }
      }
      
      /* Error */
      private void cKd()
      {
        // Byte code:
        //   0: sipush 25074
        //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: invokestatic 92	com/tencent/mm/plugin/freewifi/h$b:cIA	()Lcom/tencent/mm/plugin/freewifi/h;
        //   9: invokevirtual 97	com/tencent/mm/plugin/freewifi/h:cIz	()Ljava/lang/String;
        //   12: astore 4
        //   14: ldc 43
        //   16: ldc 99
        //   18: aload 4
        //   20: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   23: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   26: invokestatic 50	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   29: aload_0
        //   30: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   33: aload_0
        //   34: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   37: ldc 110
        //   39: invokevirtual 114	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:getString	(I)Ljava/lang/String;
        //   42: invokestatic 117	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
        //   45: aconst_null
        //   46: astore_2
        //   47: aconst_null
        //   48: astore 5
        //   50: new 119	java/net/URL
        //   53: dup
        //   54: aload 4
        //   56: invokespecial 120	java/net/URL:<init>	(Ljava/lang/String;)V
        //   59: invokevirtual 124	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   62: checkcast 126	java/net/HttpURLConnection
        //   65: astore_3
        //   66: aload_3
        //   67: ifnull +572 -> 639
        //   70: aload_3
        //   71: sipush 5000
        //   74: invokevirtual 129	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   77: aload_3
        //   78: sipush 5000
        //   81: invokevirtual 132	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   84: aload_3
        //   85: iconst_0
        //   86: invokevirtual 136	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   89: aload_3
        //   90: iconst_0
        //   91: invokevirtual 139	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   94: aload_3
        //   95: ldc 141
        //   97: ldc 143
        //   99: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   102: aload_3
        //   103: ldc 148
        //   105: ldc 143
        //   107: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   110: aload_3
        //   111: invokevirtual 152	java/net/HttpURLConnection:getResponseCode	()I
        //   114: istore_1
        //   115: ldc 43
        //   117: ldc 154
        //   119: iload_1
        //   120: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   123: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   126: invokestatic 50	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   129: sipush 200
        //   132: iload_1
        //   133: if_icmpne +328 -> 461
        //   136: ldc 43
        //   138: invokestatic 161	com/tencent/mm/plugin/freewifi/m:afm	(Ljava/lang/String;)Ljava/lang/String;
        //   141: aload_0
        //   142: getfield 24	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:spE	Ljava/lang/String;
        //   145: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   148: ifne +37 -> 185
        //   151: aload_0
        //   152: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   155: sipush 1150
        //   158: ldc 167
        //   160: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   163: aload_3
        //   164: ifnull +14 -> 178
        //   167: aload_3
        //   168: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   171: invokevirtual 179	java/io/InputStream:close	()V
        //   174: aload_3
        //   175: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   178: sipush 25074
        //   181: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   184: return
        //   185: aload_3
        //   186: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   189: invokestatic 186	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:G	(Ljava/io/InputStream;)Ljava/lang/String;
        //   192: astore_2
        //   193: ldc 43
        //   195: ldc 188
        //   197: aload_2
        //   198: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   201: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   204: invokestatic 50	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   207: aload_2
        //   208: ldc 190
        //   210: invokevirtual 194	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   213: iconst_m1
        //   214: if_icmpne +47 -> 261
        //   217: aload_0
        //   218: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   221: aload 4
        //   223: invokestatic 197	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:b	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
        //   226: aload_3
        //   227: ifnull +14 -> 241
        //   230: aload_3
        //   231: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   234: invokevirtual 179	java/io/InputStream:close	()V
        //   237: aload_3
        //   238: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   241: sipush 25074
        //   244: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   247: return
        //   248: astore_2
        //   249: ldc 43
        //   251: aload_2
        //   252: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   255: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   258: goto -21 -> 237
        //   261: aload_0
        //   262: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   265: iconst_0
        //   266: ldc 200
        //   268: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   271: ldc 43
        //   273: ldc 202
        //   275: invokestatic 50	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   278: aload_0
        //   279: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   282: iconst_0
        //   283: ldc 200
        //   285: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   288: aload_0
        //   289: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   292: aload_0
        //   293: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   296: ldc 203
        //   298: invokevirtual 114	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:getString	(I)Ljava/lang/String;
        //   301: invokestatic 117	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
        //   304: aload_0
        //   305: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   308: invokestatic 206	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:e	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;)V
        //   311: aload_0
        //   312: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   315: invokestatic 209	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:f	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;)V
        //   318: goto -155 -> 163
        //   321: astore 4
        //   323: aload_3
        //   324: astore_2
        //   325: new 211	java/io/StringWriter
        //   328: dup
        //   329: invokespecial 212	java/io/StringWriter:<init>	()V
        //   332: astore 5
        //   334: aload_3
        //   335: astore_2
        //   336: aload 4
        //   338: new 214	java/io/PrintWriter
        //   341: dup
        //   342: aload 5
        //   344: invokespecial 217	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
        //   347: invokevirtual 221	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
        //   350: aload_3
        //   351: astore_2
        //   352: ldc 43
        //   354: ldc 223
        //   356: aload 5
        //   358: invokevirtual 224	java/io/StringWriter:toString	()Ljava/lang/String;
        //   361: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   364: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   367: invokestatic 50	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   370: aload_3
        //   371: astore_2
        //   372: aload 4
        //   374: instanceof 226
        //   377: ifeq +398 -> 775
        //   380: aload_3
        //   381: astore_2
        //   382: ldc 43
        //   384: ldc 228
        //   386: iconst_2
        //   387: anewarray 4	java/lang/Object
        //   390: dup
        //   391: iconst_0
        //   392: aload_0
        //   393: getfield 29	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stS	I
        //   396: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   399: aastore
        //   400: dup
        //   401: iconst_1
        //   402: iconst_5
        //   403: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   406: aastore
        //   407: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   410: aload_3
        //   411: astore_2
        //   412: aload_0
        //   413: getfield 29	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stS	I
        //   416: iconst_5
        //   417: if_icmpge +358 -> 775
        //   420: aload_3
        //   421: astore_2
        //   422: aload_0
        //   423: invokespecial 238	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:cKc	()V
        //   426: aload_3
        //   427: ifnull +14 -> 441
        //   430: aload_3
        //   431: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   434: invokevirtual 179	java/io/InputStream:close	()V
        //   437: aload_3
        //   438: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   441: sipush 25074
        //   444: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   447: return
        //   448: astore_2
        //   449: ldc 43
        //   451: aload_2
        //   452: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   455: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   458: goto -284 -> 174
        //   461: sipush 302
        //   464: iload_1
        //   465: if_icmpne +127 -> 592
        //   468: ldc 43
        //   470: ldc 240
        //   472: iconst_1
        //   473: anewarray 4	java/lang/Object
        //   476: dup
        //   477: iconst_0
        //   478: aload_3
        //   479: ldc 242
        //   481: invokevirtual 245	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   484: aastore
        //   485: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   488: aload_3
        //   489: ldc 242
        //   491: invokevirtual 245	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   494: astore_2
        //   495: aload_2
        //   496: invokestatic 249	com/tencent/mm/plugin/freewifi/m:cX	(Ljava/lang/String;)Z
        //   499: ifne +46 -> 545
        //   502: aload_0
        //   503: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   506: aload_2
        //   507: invokestatic 197	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:b	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
        //   510: aload_3
        //   511: ifnull +14 -> 525
        //   514: aload_3
        //   515: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   518: invokevirtual 179	java/io/InputStream:close	()V
        //   521: aload_3
        //   522: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   525: sipush 25074
        //   528: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   531: return
        //   532: astore_2
        //   533: ldc 43
        //   535: aload_2
        //   536: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   539: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   542: goto -21 -> 521
        //   545: aload_0
        //   546: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   549: sipush 1146
        //   552: ldc 251
        //   554: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   557: aload_3
        //   558: ifnull +14 -> 572
        //   561: aload_3
        //   562: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   565: invokevirtual 179	java/io/InputStream:close	()V
        //   568: aload_3
        //   569: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   572: sipush 25074
        //   575: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   578: return
        //   579: astore_2
        //   580: ldc 43
        //   582: aload_2
        //   583: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   586: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   589: goto -21 -> 568
        //   592: aload_0
        //   593: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   596: sipush 1149
        //   599: ldc 253
        //   601: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   604: aload_3
        //   605: ifnull +14 -> 619
        //   608: aload_3
        //   609: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   612: invokevirtual 179	java/io/InputStream:close	()V
        //   615: aload_3
        //   616: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   619: sipush 25074
        //   622: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   625: return
        //   626: astore_2
        //   627: ldc 43
        //   629: aload_2
        //   630: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   633: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   636: goto -21 -> 615
        //   639: ldc 43
        //   641: ldc 255
        //   643: iconst_2
        //   644: anewarray 4	java/lang/Object
        //   647: dup
        //   648: iconst_0
        //   649: aload_0
        //   650: getfield 29	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stS	I
        //   653: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   656: aastore
        //   657: dup
        //   658: iconst_1
        //   659: iconst_5
        //   660: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   663: aastore
        //   664: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   667: aload_0
        //   668: getfield 29	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stS	I
        //   671: iconst_5
        //   672: if_icmpge +42 -> 714
        //   675: aload_0
        //   676: invokespecial 238	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:cKc	()V
        //   679: aload_3
        //   680: ifnull +14 -> 694
        //   683: aload_3
        //   684: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   687: invokevirtual 179	java/io/InputStream:close	()V
        //   690: aload_3
        //   691: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   694: sipush 25074
        //   697: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   700: return
        //   701: astore_2
        //   702: ldc 43
        //   704: aload_2
        //   705: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   708: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   711: goto -21 -> 690
        //   714: aload_0
        //   715: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   718: sipush 1148
        //   721: ldc_w 257
        //   724: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   727: aload_3
        //   728: ifnull +14 -> 742
        //   731: aload_3
        //   732: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   735: invokevirtual 179	java/io/InputStream:close	()V
        //   738: aload_3
        //   739: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   742: sipush 25074
        //   745: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   748: return
        //   749: astore_2
        //   750: ldc 43
        //   752: aload_2
        //   753: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   756: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   759: goto -21 -> 738
        //   762: astore_2
        //   763: ldc 43
        //   765: aload_2
        //   766: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   769: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   772: goto -335 -> 437
        //   775: aload_3
        //   776: astore_2
        //   777: aload_0
        //   778: getfield 22	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:stQ	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
        //   781: sipush 1153
        //   784: ldc_w 257
        //   787: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
        //   790: aload_3
        //   791: ifnull +14 -> 805
        //   794: aload_3
        //   795: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   798: invokevirtual 179	java/io/InputStream:close	()V
        //   801: aload_3
        //   802: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   805: sipush 25074
        //   808: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   811: return
        //   812: astore_2
        //   813: ldc 43
        //   815: aload_2
        //   816: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   819: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   822: goto -21 -> 801
        //   825: astore 4
        //   827: aload_2
        //   828: astore_3
        //   829: aload 4
        //   831: astore_2
        //   832: aload_3
        //   833: ifnull +14 -> 847
        //   836: aload_3
        //   837: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   840: invokevirtual 179	java/io/InputStream:close	()V
        //   843: aload_3
        //   844: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
        //   847: sipush 25074
        //   850: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   853: aload_2
        //   854: athrow
        //   855: astore 4
        //   857: ldc 43
        //   859: aload 4
        //   861: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   864: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   867: goto -24 -> 843
        //   870: astore_2
        //   871: goto -39 -> 832
        //   874: astore 4
        //   876: aload 5
        //   878: astore_3
        //   879: goto -556 -> 323
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	882	0	this	5
        //   114	352	1	i	int
        //   46	162	2	str1	String
        //   248	4	2	localException1	Exception
        //   324	98	2	localObject1	Object
        //   448	4	2	localException2	Exception
        //   494	13	2	str2	String
        //   532	4	2	localException3	Exception
        //   579	4	2	localException4	Exception
        //   626	4	2	localException5	Exception
        //   701	4	2	localException6	Exception
        //   749	4	2	localException7	Exception
        //   762	4	2	localException8	Exception
        //   776	1	2	localObject2	Object
        //   812	16	2	localException9	Exception
        //   831	23	2	localObject3	Object
        //   870	1	2	localObject4	Object
        //   65	814	3	localObject5	Object
        //   12	210	4	str3	String
        //   321	52	4	localException10	Exception
        //   825	5	4	localObject6	Object
        //   855	5	4	localException11	Exception
        //   874	1	4	localException12	Exception
        //   48	829	5	localStringWriter	java.io.StringWriter
        // Exception table:
        //   from	to	target	type
        //   230	237	248	java/lang/Exception
        //   70	129	321	java/lang/Exception
        //   136	163	321	java/lang/Exception
        //   185	226	321	java/lang/Exception
        //   261	318	321	java/lang/Exception
        //   468	510	321	java/lang/Exception
        //   545	557	321	java/lang/Exception
        //   592	604	321	java/lang/Exception
        //   639	679	321	java/lang/Exception
        //   714	727	321	java/lang/Exception
        //   167	174	448	java/lang/Exception
        //   514	521	532	java/lang/Exception
        //   561	568	579	java/lang/Exception
        //   608	615	626	java/lang/Exception
        //   683	690	701	java/lang/Exception
        //   731	738	749	java/lang/Exception
        //   430	437	762	java/lang/Exception
        //   794	801	812	java/lang/Exception
        //   50	66	825	finally
        //   325	334	825	finally
        //   336	350	825	finally
        //   352	370	825	finally
        //   372	380	825	finally
        //   382	410	825	finally
        //   412	420	825	finally
        //   422	426	825	finally
        //   777	790	825	finally
        //   836	843	855	java/lang/Exception
        //   70	129	870	finally
        //   136	163	870	finally
        //   185	226	870	finally
        //   261	318	870	finally
        //   468	510	870	finally
        //   545	557	870	finally
        //   592	604	870	finally
        //   639	679	870	finally
        //   714	727	870	finally
        //   50	66	874	java/lang/Exception
      }
      
      public final void run()
      {
        AppMethodBeat.i(25072);
        Context localContext = ai.getContext();
        if (localContext == null)
        {
          FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
          AppMethodBeat.o(25072);
          return;
        }
        if ((!m.cII()) || (!m.afm("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(paramString)))
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + paramString);
          FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(2131759644));
          int i = new b(paramString, localContext).cIs();
          ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=".concat(String.valueOf(i)));
          if (i != 0)
          {
            FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, i, "An attempt to switch to special portal ap failed. connectRet=".concat(String.valueOf(i)));
            AppMethodBeat.o(25072);
            return;
          }
        }
        cKd();
        AppMethodBeat.o(25072);
      }
    });
    AppMethodBeat.o(25082);
  }
  
  private void afE(String paramString)
  {
    AppMethodBeat.i(25084);
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramString;
    this.stO.sendMessage(localMessage);
    AppMethodBeat.o(25084);
  }
  
  private void bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(25083);
    ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0)
    {
      cKa();
      if (paramInt == 1154)
      {
        afE(getString(2131759642) + "(031" + k.b.spn.spp + "-" + Math.abs(paramInt) + ")");
        AppMethodBeat.o(25083);
        return;
      }
      afE(getString(2131759641) + "(031" + k.b.spn.spp + "-" + Math.abs(paramInt) + ")");
      this.stP.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25075);
          FreeWifiManufacturerLoadingUI.d(FreeWifiManufacturerLoadingUI.this).setVisibility(0);
          AppMethodBeat.o(25075);
        }
      }, 0L);
    }
    AppMethodBeat.o(25083);
  }
  
  private void cKa()
  {
    AppMethodBeat.i(25078);
    if (this.cLS != null) {
      this.cLS.stopTimer();
    }
    this.stO.sendEmptyMessage(2);
    AppMethodBeat.o(25078);
  }
  
  private static String cL(Context paramContext)
  {
    AppMethodBeat.i(25085);
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(25085);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", paramContext, "", new Object[0]);
      AppMethodBeat.o(25085);
    }
    return "(null)";
  }
  
  public final void cKb()
  {
    AppMethodBeat.i(25081);
    this.stO.sendEmptyMessage(1);
    if (this.cLS != null) {
      this.cLS.stopTimer();
    }
    this.cLS = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25071);
        FreeWifiManufacturerLoadingUI.this.stO.sendEmptyMessage(1);
        AppMethodBeat.o(25071);
        return true;
      }
    }, true);
    this.cLS.au(200L, 200L);
    afD(this.ssid);
    AppMethodBeat.o(25081);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25079);
    cKa();
    super.finish();
    AppMethodBeat.o(25079);
  }
  
  public int getLayoutId()
  {
    return 2131494172;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25080);
    super.onCreate(paramBundle);
    setMMTitle(2131759653);
    this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
    this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
    this.stH = ((ImageView)findViewById(2131300264));
    this.stI = ((TextView)findViewById(2131300265));
    this.stJ = ((Button)findViewById(2131300266));
    this.stJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25069);
        FreeWifiManufacturerLoadingUI.this.stP.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25068);
            FreeWifiManufacturerLoadingUI.d(FreeWifiManufacturerLoadingUI.this).setVisibility(4);
            AppMethodBeat.o(25068);
          }
        }, 0L);
        FreeWifiManufacturerLoadingUI.this.cKb();
        AppMethodBeat.o(25069);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25070);
        FreeWifiManufacturerLoadingUI.this.finish();
        AppMethodBeat.o(25070);
        return true;
      }
    });
    cKb();
    AppMethodBeat.o(25080);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI
 * JD-Core Version:    0.7.0.1
 */