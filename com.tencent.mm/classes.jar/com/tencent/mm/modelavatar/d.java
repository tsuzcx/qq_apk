package com.tencent.mm.modelavatar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;

public final class d
{
  public static void LA(String paramString)
  {
    AppMethodBeat.i(150212);
    j localj = q.bFE().LS(paramString);
    if (localj == null)
    {
      AppMethodBeat.o(150212);
      return;
    }
    if (!paramString.equals(localj.getUsername()))
    {
      AppMethodBeat.o(150212);
      return;
    }
    localj.osP = 0;
    localj.eQp = 64;
    q.bFE().b(localj);
    AppMethodBeat.o(150212);
  }
  
  public static Bitmap Ls(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String Lt(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void Lu(String paramString)
  {
    AppMethodBeat.i(150199);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    j localj2 = q.bFE().LS(str);
    if ((localj2 != null) && (str.equals(localj2.getUsername())) && (3 == localj2.jZY))
    {
      AppMethodBeat.o(150199);
      return;
    }
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = new j();
    }
    localj1.username = str;
    localj1.jZY = 3;
    localj1.osN = Lt(paramString);
    localj1.osM = Lt(paramString);
    localj1.gX(true);
    localj1.eQp = 31;
    q.bFE().b(localj1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap Lv(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long Lw(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!au.bwR(paramString))
    {
      AppMethodBeat.o(150201);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = Util.getLong(paramString[0], -1L);
      AppMethodBeat.o(150201);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150201);
    }
    return -1L;
  }
  
  public static long Lx(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!au.bwN(paramString))
    {
      AppMethodBeat.o(150203);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = Util.getLong(paramString[0], -1L);
      AppMethodBeat.o(150203);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150203);
    }
    return -1L;
  }
  
  public static boolean Ly(String paramString)
  {
    AppMethodBeat.i(150205);
    if (paramString == null)
    {
      Log.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      Log.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    j localj = new j();
    localj.username = paramString;
    localj.jZY = 3;
    localj.eQp = 3;
    boolean bool = q.bFE().b(localj);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static String Lz(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((Util.isNullOrNil(paramString)) || (!h.baC().aZN()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (au.bwS(paramString))
    {
      q.bFp();
      paramString = AvatarStorage.Q(au.bxd(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    q.bFp();
    paramString = AvatarStorage.Q(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, c paramc)
  {
    AppMethodBeat.i(231388);
    if ((Util.isNullOrNil(paramString)) || (!h.baC().aZN()))
    {
      AppMethodBeat.o(231388);
      return null;
    }
    String str = paramString;
    if (au.bwS(paramString)) {
      str = au.bxd(paramString);
    }
    paramString = str;
    if (ab.IN(str)) {
      paramString = "weixin";
    }
    paramString = q.bFG().b(paramString, paramBoolean, paramInt, paramc);
    AppMethodBeat.o(231388);
    return paramString;
  }
  
  public static j a(String paramString, dph paramdph, au paramau)
  {
    AppMethodBeat.i(231397);
    j localj = new j();
    localj.eQp = -1;
    localj.username = paramString;
    localj.osM = paramdph.ZhP;
    localj.osN = paramdph.ZhO;
    Log.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s], ImgFlag:%s", new Object[] { localj.getUsername(), localj.bFw(), localj.bFx(), Integer.valueOf(paramdph.aaVH) });
    boolean bool;
    if (paramdph.aaVM != 0)
    {
      bool = true;
      localj.gX(bool);
      if ((paramdph.aaVH != 3) && (paramdph.aaVH != 4)) {
        break label270;
      }
      localj.jZY = paramdph.aaVH;
    }
    for (;;)
    {
      if ((paramau != null) && (com.tencent.mm.contact.d.rs(paramau.field_type)) && ((paramdph.aaVH == 3) || (paramdph.aaVH == 1)) && (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUI, 1) == 1))
      {
        paramau = q.bFE().LS(paramString);
        if ((paramau != null) && (!Util.isNullOrNil(paramdph.ZhP)) && (!Util.isEqual(paramau.bFx(), paramdph.ZhP)))
        {
          Log.i("MicroMsg.AvatarLogic", "parseFromModContact old_smallImageUrl:%s, old_flag:%s", new Object[] { Util.nullAs(paramau.bFx(), ""), Integer.valueOf(paramau.jZY) });
          a(paramString, localj);
        }
      }
      AppMethodBeat.o(231397);
      return localj;
      bool = false;
      break;
      label270:
      if (paramdph.aaVH == 2)
      {
        localj.jZY = 3;
        a(paramString, localj);
      }
    }
  }
  
  private static void a(String paramString, j paramj)
  {
    AppMethodBeat.i(231399);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(231399);
      return;
    }
    if (!z.bAM().equals(paramString))
    {
      q.bFp();
      AvatarStorage.T(paramString, false);
      q.bFp();
      AvatarStorage.T(paramString, true);
      q.bFE().b(paramj);
      q.bFG().LB(paramString);
    }
    AppMethodBeat.o(231399);
  }
  
  public static boolean aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    j localj2 = q.bFE().LS(paramString);
    if ((localj2 != null) && (paramString.equals(localj2.getUsername())) && (paramInt == localj2.jZY))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = new j();
    }
    localj1.username = paramString;
    localj1.jZY = paramInt;
    localj1.eQp = 3;
    boolean bool = q.bFE().b(localj1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static String bp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150196);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(150196);
    return paramString1;
  }
  
  public static Bitmap f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((Util.isNullOrNil(paramString)) || (!h.baC().aZN()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    q.bFp();
    Object localObject = AvatarStorage.s(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new f();
      ((f)localObject).a(paramString, new f.d()
      {
        public final int resultCallback(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          d.this.Qh();
          Log.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(150195);
          return 0;
        }
      });
      paramString = a(paramString, false, paramInt3, null);
      AppMethodBeat.o(150209);
      return paramString;
    }
    paramString = (String)localObject;
    if (paramInt3 > 5) {
      paramString = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, paramInt3);
    }
    AppMethodBeat.o(150209);
    return paramString;
  }
  
  private static String ix(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap iy(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(ix(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
  
  public static boolean n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(150204);
    if (paramInt != 3)
    {
      AppMethodBeat.o(150204);
      return false;
    }
    boolean bool = Ly(ix(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.d
 * JD-Core Version:    0.7.0.1
 */