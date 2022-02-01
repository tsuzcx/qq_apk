package com.tencent.mm.plugin.game.chatroom;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.autogen.chatroom.HalfScreen;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.WeappJumpInfo;
import com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomAffinityUI;
import com.tencent.mm.plugin.game.commlib.e.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  public static long Xc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1: 
      return 6L;
    case 2: 
      return 7L;
    }
    return 28L;
  }
  
  public static int a(Context paramContext, JumpInfo paramJumpInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(275676);
    if (paramJumpInfo == null)
    {
      AppMethodBeat.o(275676);
      return 0;
    }
    Object localObject;
    switch (paramJumpInfo.jump_type)
    {
    default: 
      AppMethodBeat.o(275676);
      return 0;
    case 1: 
      if (Util.isNullOrNil(paramJumpInfo.jump_url))
      {
        AppMethodBeat.o(275676);
        return 0;
      }
      if (paramJumpInfo.half_screen != null) {}
      switch (paramJumpInfo.half_screen.type)
      {
      default: 
        paramJumpInfo = paramJumpInfo.jump_url;
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramJumpInfo);
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("show_bottom", false);
        ((Intent)localObject).putExtra("needRedirect", false);
        ((Intent)localObject).putExtra("neverGetA8Key", false);
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
        if (!Util.isNullOrNil(paramString)) {
          ((Intent)localObject).putExtra("KGamePreloadData", paramString);
        }
        if (paramInt > 0) {
          c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject, paramInt);
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(275676);
        return 2;
        d.a(paramContext, paramJumpInfo.jump_url, paramInt, paramJumpInfo.half_screen.screen_height_dp, -1.0F, paramString);
        AppMethodBeat.o(275676);
        return 2;
        d.a(paramContext, paramJumpInfo.jump_url, paramInt, 0, paramJumpInfo.half_screen.screen_height_percent, paramString);
        AppMethodBeat.o(275676);
        return 2;
        c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
    }
    if (paramJumpInfo.weapp_jump_info != null)
    {
      paramString = paramJumpInfo.weapp_jump_info.appid;
      paramJumpInfo = paramJumpInfo.weapp_jump_info.path;
      localObject = new g();
      ((g)localObject).appId = paramString;
      ((g)localObject).qAF = paramJumpInfo;
      ((g)localObject).euz = 0;
      ((g)localObject).scene = 1079;
      ((t)h.ax(t.class)).a(paramContext, (g)localObject);
    }
    AppMethodBeat.o(275676);
    return 3;
  }
  
  public static b.a aFq(String paramString)
  {
    AppMethodBeat.i(275629);
    if (!b.IdP.containsKey(paramString))
    {
      paramString = new b.a();
      AppMethodBeat.o(275629);
      return paramString;
    }
    paramString = (b.a)b.IdP.get(paramString);
    AppMethodBeat.o(275629);
    return paramString;
  }
  
  public static void aFr(String paramString)
  {
    AppMethodBeat.i(275646);
    b.IdP.remove(paramString);
    AppMethodBeat.o(275646);
  }
  
  public static Integer aFs(String paramString)
  {
    AppMethodBeat.i(275657);
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(275657);
      return Integer.valueOf(i);
    }
    catch (Exception paramString)
    {
      Log.e("GameChatRoom.GameChatUtils", "parseColor: " + paramString.getMessage());
      AppMethodBeat.o(275657);
    }
    return null;
  }
  
  public static Bitmap an(Bitmap paramBitmap)
  {
    AppMethodBeat.i(275730);
    long l = System.currentTimeMillis();
    int i = Color.argb(230, 0, 0, 0);
    int j = Color.argb(77, 0, 0, 0);
    aw.isDarkMode();
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
    localGradientDrawable.setGradientType(0);
    localGradientDrawable.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localGradientDrawable.draw(new Canvas(paramBitmap));
    Log.i("GameChatRoom.GameChatUtils", "addGradientDrawableToBitmap end, cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(275730);
    return paramBitmap;
  }
  
  public static final Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275625);
    if ((paramBitmap == null) || (paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(275625);
      return null;
    }
    long l = Util.currentTicks();
    try
    {
      int i = paramBitmap.getHeight();
      int j = paramBitmap.getWidth();
      float f1;
      float f3;
      float f2;
      if (j * paramInt1 > paramInt2 * i)
      {
        f1 = paramInt1 / i;
        f3 = (paramInt2 - j * f1) * 0.5F;
        f2 = 0.0F;
      }
      for (;;)
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt1, paramBitmap.getConfig());
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(f1, f1);
        localMatrix.postTranslate(Math.round(f3), Math.round(f2));
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawBitmap(paramBitmap, localMatrix, null);
        localCanvas.setBitmap(null);
        paramBitmap = an(BitmapUtil.fastblur(localBitmap, 150));
        Log.i("GameChatRoom.GameChatUtils", String.format("getGameChatRoomBg, cost:%d", new Object[] { Long.valueOf(Util.ticksToNow(l)) }));
        AppMethodBeat.o(275625);
        return paramBitmap;
        f1 = paramInt2 / j;
        f2 = (paramInt1 - i * f1) * 0.5F;
        f3 = 0.0F;
      }
      return null;
    }
    catch (Exception paramBitmap)
    {
      Log.printErrStackTrace("GameChatRoom.GameChatUtils", paramBitmap, "getGameChatRoomBg", new Object[0]);
      AppMethodBeat.o(275625);
    }
  }
  
  public static void cf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(275636);
    b.a locala = aFq(paramString);
    locala.IdU = paramBoolean;
    b.IdP.put(paramString, locala);
    AppMethodBeat.o(275636);
  }
  
  public static void cg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(275643);
    b.a locala = aFq(paramString);
    locala.IdV = paramBoolean;
    b.IdP.put(paramString, locala);
    AppMethodBeat.o(275643);
  }
  
  public static boolean fCo()
  {
    AppMethodBeat.i(275700);
    if (((com.tencent.mm.game.report.a.b)h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yHN, 0) == 1)
    {
      AppMethodBeat.o(275700);
      return true;
    }
    AppMethodBeat.o(275700);
    return false;
  }
  
  public static int fo(String paramString, int paramInt)
  {
    AppMethodBeat.i(275663);
    if (Util.isNullOrNil(paramString))
    {
      paramInt = MMApplicationContext.getResources().getColor(paramInt);
      AppMethodBeat.o(275663);
      return paramInt;
    }
    Integer localInteger = aFs(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = Integer.valueOf(MMApplicationContext.getResources().getColor(paramInt));
    }
    paramInt = paramString.intValue();
    AppMethodBeat.o(275663);
    return paramInt;
  }
  
  public static boolean hI(Context paramContext)
  {
    return (paramContext instanceof GameChatRoomAffinityUI);
  }
  
  public static String iO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275695);
    Uri localUri = Uri.parse(paramString1);
    String str = localUri.getQuery();
    if (str != null) {
      paramString2 = str + "&" + paramString2;
    }
    for (;;)
    {
      try
      {
        paramString2 = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), paramString2, localUri.getFragment()).toString();
        paramString1 = paramString2;
      }
      catch (URISyntaxException paramString2)
      {
        Log.printErrStackTrace("GameChatRoom.GameChatUtils", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(275695);
      return paramString1;
    }
  }
  
  public static String ig(List<String> paramList)
  {
    AppMethodBeat.i(275652);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(275652);
      return "()";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int i = 0;
    while (i < paramList.size() - 1)
    {
      localStringBuilder.append("'").append((String)paramList.get(i)).append("',");
      i += 1;
    }
    localStringBuilder.append("'").append((String)paramList.get(paramList.size() - 1)).append("')");
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(275652);
    return paramList;
  }
  
  public static boolean m(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(275714);
    boolean bool = paramMMActivity instanceof GameChatRoomAffinityUI;
    if ((b.IdR != null) && (b.IdR.contains(GameChatRoomAffinityUI.class.getName()))) {}
    for (int i = 1; (bool) && (i != 0); i = 0)
    {
      AppMethodBeat.o(275714);
      return true;
    }
    AppMethodBeat.o(275714);
    return false;
  }
  
  public static int rA(long paramLong)
  {
    return (int)(paramLong >> 4 & 0xFFFFFFFF);
  }
  
  public static boolean wd(boolean paramBoolean)
  {
    AppMethodBeat.i(275719);
    Iterator localIterator = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getAppTasks().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)localIterator.next();
      ComponentName localComponentName = localAppTask.getTaskInfo().baseIntent.getComponent();
      if ((localComponentName != null) && (localComponentName.getClassName().equals(GameChatRoomAffinityUI.class.getName())))
      {
        if (paramBoolean) {
          localAppTask.finishAndRemoveTask();
        }
        Log.i("GameChatRoom.GameChatUtils", "finish and remove multi task, clear:%b", new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(275719);
        return true;
      }
    }
    AppMethodBeat.o(275719);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.e
 * JD-Core Version:    0.7.0.1
 */