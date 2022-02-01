package com.tencent.mm.plugin.game.chatroom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.game.autogen.chatroom.HalfScreen;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.WeappJumpInfo;
import com.tencent.mm.plugin.game.commlib.e.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.List;
import java.util.Map;

public final class e
{
  public static int NL(long paramLong)
  {
    return (int)(paramLong >> 4 & 0xFFFFFFFF);
  }
  
  public static int a(Context paramContext, JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(210587);
    int i = a(paramContext, paramJumpInfo, 0, null);
    AppMethodBeat.o(210587);
    return i;
  }
  
  public static int a(Context paramContext, JumpInfo paramJumpInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(210585);
    if (paramJumpInfo == null)
    {
      AppMethodBeat.o(210585);
      return 0;
    }
    Object localObject;
    switch (paramJumpInfo.jump_type)
    {
    default: 
      AppMethodBeat.o(210585);
      return 0;
    case 1: 
      if (Util.isNullOrNil(paramJumpInfo.jump_url))
      {
        AppMethodBeat.o(210585);
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
        ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
        ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
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
        AppMethodBeat.o(210585);
        return 2;
        d.a(paramContext, paramJumpInfo.jump_url, paramInt, paramJumpInfo.half_screen.screen_height_dp, -1.0F, paramString);
        AppMethodBeat.o(210585);
        return 2;
        d.a(paramContext, paramJumpInfo.jump_url, paramInt, 0, paramJumpInfo.half_screen.screen_height_percent, paramString);
        AppMethodBeat.o(210585);
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
      ((g)localObject).nBq = paramJumpInfo;
      ((g)localObject).cBU = 0;
      ((g)localObject).scene = 1079;
      ((r)h.ae(r.class)).a(paramContext, (g)localObject);
    }
    AppMethodBeat.o(210585);
    return 3;
  }
  
  public static boolean aIP(String paramString)
  {
    AppMethodBeat.i(210580);
    if (!b.CrJ.containsKey(paramString))
    {
      AppMethodBeat.o(210580);
      return false;
    }
    boolean bool = ((Boolean)b.CrJ.get(paramString)).booleanValue();
    AppMethodBeat.o(210580);
    return bool;
  }
  
  public static int aIQ(String paramString)
  {
    AppMethodBeat.i(210584);
    int i = -1;
    try
    {
      int j = Color.parseColor(paramString);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("GameChatRoom.GameChatUtils", "parseColor: " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(210584);
    return i;
  }
  
  public static Bitmap ab(Bitmap paramBitmap)
  {
    AppMethodBeat.i(210588);
    long l = System.currentTimeMillis();
    int i = Color.argb(230, 0, 0, 0);
    int j = Color.argb(77, 0, 0, 0);
    ar.isDarkMode();
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
    localGradientDrawable.setGradientType(0);
    localGradientDrawable.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localGradientDrawable.draw(new Canvas(paramBitmap));
    Log.i("GameChatRoom.GameChatUtils", "addGradientDrawableToBitmap end, cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(210588);
    return paramBitmap;
  }
  
  public static void bL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(210581);
    b.CrJ.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(210581);
  }
  
  public static final Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210579);
    if ((paramBitmap == null) || (paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(210579);
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
        paramBitmap = ab(BitmapUtil.fastblur(localBitmap, 150));
        Log.i("GameChatRoom.GameChatUtils", String.format("getGameChatRoomBg, cost:%d", new Object[] { Long.valueOf(Util.ticksToNow(l)) }));
        AppMethodBeat.o(210579);
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
      AppMethodBeat.o(210579);
    }
  }
  
  public static String fq(List<String> paramList)
  {
    AppMethodBeat.i(210583);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(210583);
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
    AppMethodBeat.o(210583);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.e
 * JD-Core Version:    0.7.0.1
 */