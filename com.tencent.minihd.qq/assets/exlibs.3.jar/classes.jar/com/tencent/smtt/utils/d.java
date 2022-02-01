package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static DexClassLoader b = null;
  private static Looper c = null;
  private static d d = null;
  public String a = "";
  
  private d(Context paramContext)
  {
    this.a = (paramContext.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin");
  }
  
  public static d a(Context paramContext)
  {
    if (d == null) {
      d = new d(paramContext);
    }
    return d;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString, final a parama)
  {
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: aconst_null
        //   4: astore 4
        //   6: aconst_null
        //   7: astore 5
        //   9: aconst_null
        //   10: astore 8
        //   12: new 26	java/net/URL
        //   15: dup
        //   16: ldc 28
        //   18: invokespecial 31	java/net/URL:<init>	(Ljava/lang/String;)V
        //   21: invokevirtual 35	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   24: checkcast 37	java/net/HttpURLConnection
        //   27: astore 6
        //   29: aload 6
        //   31: invokevirtual 41	java/net/HttpURLConnection:getContentLength	()I
        //   34: istore_2
        //   35: aload 6
        //   37: sipush 5000
        //   40: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   43: aload 6
        //   45: invokevirtual 48	java/net/HttpURLConnection:connect	()V
        //   48: aload 6
        //   50: invokevirtual 52	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   53: astore 6
        //   55: aload 8
        //   57: astore 7
        //   59: aload 5
        //   61: astore 4
        //   63: aload 6
        //   65: astore 5
        //   67: new 54	java/io/File
        //   70: dup
        //   71: aload_0
        //   72: getfield 15	com/tencent/smtt/utils/d$2:a	Ljava/lang/String;
        //   75: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
        //   78: invokestatic 61	com/tencent/smtt/utils/FileUtil:d	(Ljava/io/File;)Ljava/io/FileOutputStream;
        //   81: astore 8
        //   83: aload 8
        //   85: astore 7
        //   87: aload 8
        //   89: astore 4
        //   91: aload 6
        //   93: astore 5
        //   95: sipush 8192
        //   98: newarray byte
        //   100: astore 9
        //   102: iconst_0
        //   103: istore_1
        //   104: aload 8
        //   106: astore 7
        //   108: aload 8
        //   110: astore 4
        //   112: aload 6
        //   114: astore 5
        //   116: aload 6
        //   118: aload 9
        //   120: invokevirtual 67	java/io/InputStream:read	([B)I
        //   123: istore_3
        //   124: iload_3
        //   125: ifle +117 -> 242
        //   128: iload_1
        //   129: iload_3
        //   130: iadd
        //   131: istore_1
        //   132: aload 8
        //   134: astore 7
        //   136: aload 8
        //   138: astore 4
        //   140: aload 6
        //   142: astore 5
        //   144: aload 8
        //   146: aload 9
        //   148: iconst_0
        //   149: iload_3
        //   150: invokevirtual 73	java/io/OutputStream:write	([BII)V
        //   153: aload 8
        //   155: astore 7
        //   157: aload 8
        //   159: astore 4
        //   161: aload 6
        //   163: astore 5
        //   165: iload_1
        //   166: bipush 100
        //   168: imul
        //   169: iload_2
        //   170: idiv
        //   171: istore_3
        //   172: aload 8
        //   174: astore 7
        //   176: aload 8
        //   178: astore 4
        //   180: aload 6
        //   182: astore 5
        //   184: aload_0
        //   185: getfield 17	com/tencent/smtt/utils/d$2:b	Lcom/tencent/smtt/utils/d$a;
        //   188: iload_3
        //   189: invokeinterface 77 2 0
        //   194: goto -90 -> 104
        //   197: astore 8
        //   199: aload 7
        //   201: astore 4
        //   203: aload 6
        //   205: astore 5
        //   207: aload 8
        //   209: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   212: aload 7
        //   214: astore 4
        //   216: aload 6
        //   218: astore 5
        //   220: aload_0
        //   221: getfield 17	com/tencent/smtt/utils/d$2:b	Lcom/tencent/smtt/utils/d$a;
        //   224: aload 8
        //   226: invokeinterface 83 2 0
        //   231: aload 6
        //   233: invokevirtual 86	java/io/InputStream:close	()V
        //   236: aload 7
        //   238: invokevirtual 87	java/io/OutputStream:close	()V
        //   241: return
        //   242: aload 8
        //   244: astore 7
        //   246: aload 8
        //   248: astore 4
        //   250: aload 6
        //   252: astore 5
        //   254: aload_0
        //   255: getfield 17	com/tencent/smtt/utils/d$2:b	Lcom/tencent/smtt/utils/d$a;
        //   258: invokeinterface 89 1 0
        //   263: aload 6
        //   265: invokevirtual 86	java/io/InputStream:close	()V
        //   268: aload 8
        //   270: invokevirtual 87	java/io/OutputStream:close	()V
        //   273: return
        //   274: astore 4
        //   276: aload 4
        //   278: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   281: return
        //   282: astore 4
        //   284: aload 4
        //   286: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   289: goto -21 -> 268
        //   292: astore 4
        //   294: aload 4
        //   296: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   299: goto -63 -> 236
        //   302: astore 4
        //   304: aload 4
        //   306: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   309: return
        //   310: astore 6
        //   312: aconst_null
        //   313: astore 5
        //   315: aload 5
        //   317: invokevirtual 86	java/io/InputStream:close	()V
        //   320: aload 4
        //   322: invokevirtual 87	java/io/OutputStream:close	()V
        //   325: aload 6
        //   327: athrow
        //   328: astore 5
        //   330: aload 5
        //   332: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   335: goto -15 -> 320
        //   338: astore 4
        //   340: aload 4
        //   342: invokevirtual 80	java/lang/Exception:printStackTrace	()V
        //   345: goto -20 -> 325
        //   348: astore 6
        //   350: goto -35 -> 315
        //   353: astore 8
        //   355: aconst_null
        //   356: astore 6
        //   358: goto -159 -> 199
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	361	0	this	2
        //   103	66	1	i	int
        //   34	137	2	j	int
        //   123	66	3	k	int
        //   4	245	4	localObject1	Object
        //   274	3	4	localException1	Exception
        //   282	3	4	localException2	Exception
        //   292	3	4	localException3	Exception
        //   302	19	4	localException4	Exception
        //   338	3	4	localException5	Exception
        //   7	309	5	localObject2	Object
        //   328	3	5	localException6	Exception
        //   27	237	6	localObject3	Object
        //   310	16	6	localObject4	Object
        //   348	1	6	localObject5	Object
        //   356	1	6	localObject6	Object
        //   1	244	7	localObject7	Object
        //   10	167	8	localFileOutputStream	java.io.FileOutputStream
        //   197	72	8	localException7	Exception
        //   353	1	8	localException8	Exception
        //   100	47	9	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   67	83	197	java/lang/Exception
        //   95	102	197	java/lang/Exception
        //   116	124	197	java/lang/Exception
        //   144	153	197	java/lang/Exception
        //   165	172	197	java/lang/Exception
        //   184	194	197	java/lang/Exception
        //   254	263	197	java/lang/Exception
        //   268	273	274	java/lang/Exception
        //   263	268	282	java/lang/Exception
        //   231	236	292	java/lang/Exception
        //   236	241	302	java/lang/Exception
        //   12	55	310	finally
        //   315	320	328	java/lang/Exception
        //   320	325	338	java/lang/Exception
        //   67	83	348	finally
        //   95	102	348	finally
        //   116	124	348	finally
        //   144	153	348	finally
        //   165	172	348	finally
        //   184	194	348	finally
        //   207	212	348	finally
        //   220	231	348	finally
        //   254	263	348	finally
        //   12	55	353	java/lang/Exception
      }
    }.start();
  }
  
  public void a(final String paramString, final WebView paramWebView, final Context paramContext)
  {
    final RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    final TextView localTextView = new TextView(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localTextView.setText("加载中，请稍后...");
    localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    paramWebView.addView(localRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.a + File.separator + "DebugPlugin.tbs";
    FileUtil.b(new File((String)localObject));
    a((String)localObject, new a()
    {
      public void a()
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(d.1.this.b, "下载成功", 0).show();
            d.1.this.c.setVisibility(4);
            d.this.a(d.1.this.d, d.1.this.a, d.1.this.b, d.a());
          }
        });
      }
      
      public void a(final int paramAnonymousInt)
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            d.1.this.e.setText("已下载" + paramAnonymousInt + "%");
          }
        });
      }
      
      public void a(Throwable paramAnonymousThrowable)
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(d.1.this.b, "下载失败，请检查网络", 0).show();
          }
        });
      }
    });
  }
  
  @SuppressLint({"NewApi"})
  public void a(String paramString, WebView paramWebView, Context paramContext, Looper paramLooper)
  {
    TbsLog.i("debugtbs", "showPluginView -- url: " + paramString + "; webview: " + paramWebView + "; context: " + paramContext);
    Object localObject1 = this.a + File.separator + "DebugPlugin.tbs";
    Object localObject2 = this.a + File.separator + "DebugPlugin.apk";
    Object localObject3 = new File((String)localObject1);
    localObject1 = new File((String)localObject2);
    c = paramLooper;
    if (((File)localObject3).exists())
    {
      ((File)localObject1).delete();
      ((File)localObject3).renameTo((File)localObject1);
    }
    if (!((File)localObject1).exists())
    {
      TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
      a(paramString, paramWebView, paramContext);
      return;
    }
    try
    {
      localObject4 = b.a(paramContext, true, new File((String)localObject2));
      if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(localObject4))
      {
        TbsLog.e("debugtbs", "verifyPlugin apk: " + (String)localObject2 + " signature failed - sig: " + (String)localObject4);
        Toast.makeText(paramContext, "插件校验失败，请重试", 0).show();
        ((File)localObject3).delete();
        ((File)localObject1).delete();
        return;
      }
    }
    catch (Exception paramString)
    {
      FileUtil.b((File)localObject1);
      paramString.printStackTrace();
      return;
    }
    localObject3 = this.a + File.separator + "opt";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    if (b == null) {
      b = new DexClassLoader((String)localObject2, (String)localObject3, null, paramContext.getClassLoader());
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("url", paramString);
    ((Map)localObject2).put("tbs_version", "" + WebView.getTbsSDKVersion(paramContext));
    ((Map)localObject2).put("tbs_core_version", "" + WebView.getTbsCoreVersion(paramContext));
    if (c != null) {
      ((Map)localObject2).put("looper", paramLooper);
    }
    paramString = b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[] { Context.class, Map.class }).newInstance(new Object[] { paramContext, localObject2 });
    if ((paramString instanceof FrameLayout))
    {
      paramString = (FrameLayout)paramString;
      paramWebView.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("debugtbs", "show " + paramString + " successful in " + paramWebView);
      return;
    }
    TbsLog.e("debugtbs", "get debugview failure: " + paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.d
 * JD-Core Version:    0.7.0.1
 */