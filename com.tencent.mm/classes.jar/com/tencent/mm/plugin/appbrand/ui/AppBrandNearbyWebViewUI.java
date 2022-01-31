package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.aa;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.ui.af;

public final class AppBrandNearbyWebViewUI
  extends WebViewUI
{
  private static Boolean eth = null;
  
  /* Error */
  public static boolean Mo()
  {
    // Byte code:
    //   0: sipush 17072
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:eth	Ljava/lang/Boolean;
    //   9: ifnonnull +65 -> 74
    //   12: new 26	java/io/FileInputStream
    //   15: dup
    //   16: new 28	java/io/File
    //   19: dup
    //   20: invokestatic 34	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   23: ldc 36
    //   25: invokespecial 39	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: new 44	java/util/Properties
    //   37: dup
    //   38: invokespecial 45	java/util/Properties:<init>	()V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 49	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: ldc 51
    //   54: ldc 53
    //   56: invokevirtual 57	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: ldc 59
    //   61: invokevirtual 65	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   64: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: putstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:eth	Ljava/lang/Boolean;
    //   70: aload_2
    //   71: invokevirtual 74	java/io/FileInputStream:close	()V
    //   74: getstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:eth	Ljava/lang/Boolean;
    //   77: invokevirtual 77	java/lang/Boolean:booleanValue	()Z
    //   80: istore_0
    //   81: sipush 17072
    //   84: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iload_0
    //   88: ireturn
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: getstatic 83	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   97: putstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:eth	Ljava/lang/Boolean;
    //   100: aload_2
    //   101: ifnull -27 -> 74
    //   104: aload_2
    //   105: invokevirtual 74	java/io/FileInputStream:close	()V
    //   108: goto -34 -> 74
    //   111: astore_1
    //   112: goto -38 -> 74
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_2
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 74	java/io/FileInputStream:close	()V
    //   126: sipush 17072
    //   129: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: goto -61 -> 74
    //   138: astore_2
    //   139: goto -13 -> 126
    //   142: astore_2
    //   143: aload_1
    //   144: astore_3
    //   145: aload_2
    //   146: astore_1
    //   147: aload_3
    //   148: astore_2
    //   149: goto -31 -> 118
    //   152: astore_1
    //   153: goto -61 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   80	8	0	bool	boolean
    //   33	18	1	localFileInputStream1	java.io.FileInputStream
    //   89	1	1	localException1	java.lang.Exception
    //   93	1	1	localFileInputStream2	java.io.FileInputStream
    //   111	1	1	localException2	java.lang.Exception
    //   115	18	1	localObject1	java.lang.Object
    //   134	10	1	localException3	java.lang.Exception
    //   146	1	1	localObject2	java.lang.Object
    //   152	1	1	localException4	java.lang.Exception
    //   31	92	2	localFileInputStream3	java.io.FileInputStream
    //   138	1	2	localException5	java.lang.Exception
    //   142	4	2	localObject3	java.lang.Object
    //   148	1	2	localObject4	java.lang.Object
    //   41	107	3	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	32	89	java/lang/Exception
    //   104	108	111	java/lang/Exception
    //   12	32	115	finally
    //   70	74	134	java/lang/Exception
    //   122	126	138	java/lang/Exception
    //   34	42	142	finally
    //   44	49	142	finally
    //   51	70	142	finally
    //   94	100	142	finally
    //   34	42	152	java/lang/Exception
    //   44	49	152	java/lang/Exception
    //   51	70	152	java/lang/Exception
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(17070);
    super.aMf();
    setActionbarColor(-855310);
    AppMethodBeat.o(17070);
  }
  
  public final int aMg()
  {
    AppMethodBeat.i(17071);
    if ((Build.VERSION.SDK_INT >= 23) && ((!h.Mn()) || (!Mo())))
    {
      af.a(getWindow(), true);
      AppMethodBeat.o(17071);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = aa.gSb;
      AppMethodBeat.o(17071);
      return i;
    }
    int i = super.aMg();
    AppMethodBeat.o(17071);
    return i;
  }
  
  public final boolean aMh()
  {
    return true;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(17069);
    super.initView();
    AppMethodBeat.o(17069);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17067);
    if (getIntent() != null)
    {
      getIntent().putExtra("forceHideShare", true);
      getIntent().putExtra("disable_bounce_scroll", true);
      getIntent().putExtra("show_long_click_popup_menu", false);
      getIntent().putExtra("key_load_js_without_delay", true);
      getIntent().putExtra("geta8key_scene", 41);
    }
    super.onCreate(paramBundle);
    setResult(-1);
    AppMethodBeat.o(17067);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setMMTitle(String paramString)
  {
    AppMethodBeat.i(17068);
    super.setMMTitle(paramString);
    setMMTitleColor(-16777216);
    AppMethodBeat.o(17068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI
 * JD-Core Version:    0.7.0.1
 */