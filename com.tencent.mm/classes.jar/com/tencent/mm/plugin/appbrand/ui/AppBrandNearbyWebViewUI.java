package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.ui.aw;

public final class AppBrandNearbyWebViewUI
  extends WebViewUI
{
  private static Boolean isMIUIV8 = null;
  
  /* Error */
  public static boolean isMIUIV8()
  {
    // Byte code:
    //   0: sipush 21123
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:isMIUIV8	Ljava/lang/Boolean;
    //   9: ifnonnull +78 -> 87
    //   12: aconst_null
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_1
    //   16: new 25	com/tencent/mm/vfs/u
    //   19: dup
    //   20: invokestatic 31	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   23: ldc 33
    //   25: invokespecial 36	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: invokestatic 42	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   31: astore_3
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: astore_2
    //   36: new 44	java/util/Properties
    //   39: dup
    //   40: invokespecial 45	java/util/Properties:<init>	()V
    //   43: astore 4
    //   45: aload_3
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: aload 4
    //   51: aload_3
    //   52: invokevirtual 49	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_3
    //   56: astore_1
    //   57: aload_3
    //   58: astore_2
    //   59: aload 4
    //   61: ldc 51
    //   63: ldc 53
    //   65: invokevirtual 57	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: ldc 59
    //   70: invokevirtual 65	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: putstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:isMIUIV8	Ljava/lang/Boolean;
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 76	java/io/InputStream:close	()V
    //   87: getstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:isMIUIV8	Ljava/lang/Boolean;
    //   90: invokevirtual 79	java/lang/Boolean:booleanValue	()Z
    //   93: istore_0
    //   94: sipush 21123
    //   97: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iload_0
    //   101: ireturn
    //   102: astore_2
    //   103: aload_1
    //   104: astore_2
    //   105: getstatic 85	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   108: putstatic 10	com/tencent/mm/plugin/appbrand/ui/AppBrandNearbyWebViewUI:isMIUIV8	Ljava/lang/Boolean;
    //   111: aload_1
    //   112: ifnull -25 -> 87
    //   115: aload_1
    //   116: invokevirtual 76	java/io/InputStream:close	()V
    //   119: goto -32 -> 87
    //   122: astore_1
    //   123: goto -36 -> 87
    //   126: astore_1
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 76	java/io/InputStream:close	()V
    //   135: sipush 21123
    //   138: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: goto -57 -> 87
    //   147: astore_2
    //   148: goto -13 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   93	8	0	bool	boolean
    //   15	101	1	localObject1	java.lang.Object
    //   122	1	1	localException1	java.lang.Exception
    //   126	16	1	localObject2	java.lang.Object
    //   143	1	1	localException2	java.lang.Exception
    //   13	46	2	localObject3	java.lang.Object
    //   102	1	2	localException3	java.lang.Exception
    //   104	28	2	localObject4	java.lang.Object
    //   147	1	2	localException4	java.lang.Exception
    //   31	53	3	localInputStream	java.io.InputStream
    //   43	17	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   16	32	102	java/lang/Exception
    //   36	45	102	java/lang/Exception
    //   49	55	102	java/lang/Exception
    //   59	79	102	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   16	32	126	finally
    //   36	45	126	finally
    //   49	55	126	finally
    //   59	79	126	finally
    //   105	111	126	finally
    //   83	87	143	java/lang/Exception
    //   131	135	147	java/lang/Exception
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(21121);
    super.cKX();
    setActionbarColor(-855310);
    AppMethodBeat.o(21121);
  }
  
  public final int cKY()
  {
    AppMethodBeat.i(21122);
    if ((Build.VERSION.SDK_INT >= 23) && ((!g.isMIUI()) || (!isMIUIV8())))
    {
      aw.c(getWindow(), true);
      AppMethodBeat.o(21122);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ak.qxA;
      AppMethodBeat.o(21122);
      return i;
    }
    int i = super.cKY();
    AppMethodBeat.o(21122);
    return i;
  }
  
  public final boolean cKZ()
  {
    return true;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(21120);
    super.initView();
    AppMethodBeat.o(21120);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21118);
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
    AppMethodBeat.o(21118);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setMMTitle(String paramString)
  {
    AppMethodBeat.i(21119);
    super.setMMTitle(paramString);
    setMMTitleColor(getContext().getResources().getColor(ba.c.FG_0));
    AppMethodBeat.o(21119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI
 * JD-Core Version:    0.7.0.1
 */