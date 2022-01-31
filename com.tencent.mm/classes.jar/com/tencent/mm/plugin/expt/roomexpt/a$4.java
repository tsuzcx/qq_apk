package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.mm.h.b.a.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  implements Runnable
{
  a$4(a parama, long paramLong, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    long l1 = bk.UZ();
    long l2 = bk.UX();
    String str1;
    boolean bool1;
    e locale;
    Object localObject;
    label97:
    int i;
    if (a.a(this.jII).cjo <= 0L)
    {
      a.a(this.jII).uP();
      a.c(this.jII);
      str1 = a.e(this.jII);
      bool1 = a.m(this.jIK, this.jIL);
      locale = a.f(this.jII).cX(this.jIJ, str1);
      String str2 = this.jIJ;
      if (locale == null) {
        break label347;
      }
      localObject = locale;
      y.i("MicroMsg.ChatRoomExptService", "get db [%s %s] item [%s]", new Object[] { str2, str1, localObject });
      if (locale == null) {
        break label369;
      }
      locale.field_sendCount += this.jIL;
      locale.field_unReadCount += this.jIM;
      int j = locale.field_disRedDotCount;
      if (!bool1) {
        break label354;
      }
      i = 1;
      label171:
      locale.field_disRedDotCount = (i + j);
      j = locale.field_enterCount;
      if (!bool1) {
        break label359;
      }
      i = 0;
      label192:
      locale.field_enterCount = (i + j);
      locale.field_stayTime += this.jIK;
      if (!this.iFZ) {
        break label364;
      }
      i = 1;
      label224:
      locale.field_isMute = i;
      bool1 = true;
      a.a(locale);
      if (!bool1) {
        break label492;
      }
    }
    label347:
    label354:
    label359:
    label487:
    label492:
    for (boolean bool2 = a.f(this.jII).c(locale);; bool2 = a.f(this.jII).b(locale))
    {
      if (!bool2) {
        h.nFQ.h(869L, 32L, 1L);
      }
      y.i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(bk.cp(l1)), locale });
      return;
      if (l2 - a.a(this.jII).cjo < 604800L) {
        break;
      }
      a.d(this.jII);
      return;
      localObject = "null";
      break label97;
      i = 0;
      break label171;
      i = 1;
      break label192;
      label364:
      i = 0;
      break label224;
      label369:
      locale = new e();
      locale.field_chatroom = this.jIJ;
      locale.field_nickname = this.jIN;
      locale.field_daySec = str1;
      locale.field_sendCount = this.jIL;
      if (this.iFZ)
      {
        i = 1;
        locale.field_isMute = i;
        locale.field_unReadCount = this.jIM;
        if (!bool1) {
          break label482;
        }
        i = 1;
        locale.field_disRedDotCount = i;
        if (!bool1) {
          break label487;
        }
      }
      for (i = 0;; i = 1)
      {
        locale.field_enterCount = i;
        locale.field_stayTime = this.jIK;
        bool1 = false;
        break;
        i = 0;
        break label421;
        i = 0;
        break label443;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.4
 * JD-Core Version:    0.7.0.1
 */