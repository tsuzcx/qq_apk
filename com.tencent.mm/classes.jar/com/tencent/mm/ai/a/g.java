package com.tencent.mm.ai.a;

import android.database.Cursor;
import com.tencent.mm.h.c.ab;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends i<ab>
{
  public static final String[] dXp = { i.a(f.buS, "BizChatMyUserInfo") };
  private e dXw;
  private final k<g.a, g.a.b> eeJ = new g.1(this);
  
  public g(e parame)
  {
    super(parame, f.buS, "BizChatMyUserInfo", null);
    this.dXw = parame;
    parame.gk("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
  }
  
  public final boolean a(f paramf)
  {
    y.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
    boolean bool = super.b(paramf);
    if (bool)
    {
      g.a.b localb = new g.a.b();
      localb.bJw = paramf.field_brandUserName;
      localb.ehJ = g.a.a.ehF;
      localb.ehK = paramf;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
      return bool;
    }
    y.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
    return bool;
  }
  
  public final boolean b(f paramf)
  {
    y.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
    if (paramf == null)
    {
      y.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
      return false;
    }
    boolean bool = super.a(paramf);
    if (bool)
    {
      g.a.b localb = new g.a.b();
      localb.bJw = paramf.field_brandUserName;
      localb.ehJ = g.a.a.ehH;
      localb.ehK = paramf;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
      return bool;
    }
    y.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
    return bool;
  }
  
  public final int getCount()
  {
    int i = 0;
    y.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
    Cursor localCursor = this.dXw.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
  
  public final boolean lA(String paramString)
  {
    boolean bool1 = false;
    if (bk.bl(paramString)) {
      y.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
    }
    f localf;
    boolean bool2;
    do
    {
      return bool1;
      localf = new f();
      localf.field_brandUserName = paramString;
      bool2 = super.a(localf, new String[] { "brandUserName" });
      bool1 = bool2;
    } while (!bool2);
    paramString = new g.a.b();
    paramString.bJw = localf.field_brandUserName;
    paramString.ehJ = g.a.a.ehG;
    paramString.ehK = localf;
    this.eeJ.bV(paramString);
    this.eeJ.doNotify();
    return bool2;
  }
  
  public final f lz(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
      return null;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    super.b(localf, new String[0]);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a.g
 * JD-Core Version:    0.7.0.1
 */