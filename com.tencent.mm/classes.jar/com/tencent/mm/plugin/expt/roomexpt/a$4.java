package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$4
  implements Runnable
{
  a$4(a parama, long paramLong, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(73563);
    long l1 = bo.yB();
    long l2 = bo.aox();
    String str1;
    boolean bool1;
    e locale;
    Object localObject;
    label102:
    int i;
    if (a.a(this.mcI).cUd <= 0L)
    {
      a.a(this.mcI).Fm();
      a.c(this.mcI);
      str1 = a.e(this.mcI);
      bool1 = a.r(this.mcK, this.mcL);
      locale = a.f(this.mcI).el(this.mcJ, str1);
      String str2 = this.mcJ;
      if (locale == null) {
        break label360;
      }
      localObject = locale;
      ab.i("MicroMsg.ChatRoomExptService", "get db [%s %s] item [%s]", new Object[] { str2, str1, localObject });
      if (locale == null) {
        break label382;
      }
      locale.field_sendCount += this.mcL;
      locale.field_unReadCount += this.mcM;
      int j = locale.field_disRedDotCount;
      if (!bool1) {
        break label367;
      }
      i = 1;
      label176:
      locale.field_disRedDotCount = (i + j);
      j = locale.field_enterCount;
      if (!bool1) {
        break label372;
      }
      i = 0;
      label197:
      locale.field_enterCount = (i + j);
      locale.field_stayTime += this.mcK;
      if (!this.kLR) {
        break label377;
      }
      i = 1;
      label229:
      locale.field_isMute = i;
      bool1 = true;
      a.a(locale);
      if (!bool1) {
        break label505;
      }
    }
    label360:
    label367:
    label372:
    label500:
    label505:
    for (boolean bool2 = a.f(this.mcI).c(locale);; bool2 = a.f(this.mcI).b(locale))
    {
      if (!bool2) {
        h.qsU.cT(869, 32);
      }
      ab.i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(bo.av(l1)), locale });
      AppMethodBeat.o(73563);
      return;
      if (l2 - a.a(this.mcI).cUd < 604800L) {
        break;
      }
      a.d(this.mcI);
      AppMethodBeat.o(73563);
      return;
      localObject = "null";
      break label102;
      i = 0;
      break label176;
      i = 1;
      break label197;
      label377:
      i = 0;
      break label229;
      label382:
      locale = new e();
      locale.field_chatroom = this.mcJ;
      locale.field_nickname = this.mcN;
      locale.field_daySec = str1;
      locale.field_sendCount = this.mcL;
      if (this.kLR)
      {
        i = 1;
        locale.field_isMute = i;
        locale.field_unReadCount = this.mcM;
        if (!bool1) {
          break label495;
        }
        i = 1;
        locale.field_disRedDotCount = i;
        if (!bool1) {
          break label500;
        }
      }
      for (i = 0;; i = 1)
      {
        locale.field_enterCount = i;
        locale.field_stayTime = this.mcK;
        bool1 = false;
        break;
        i = 0;
        break label434;
        i = 0;
        break label456;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.4
 * JD-Core Version:    0.7.0.1
 */