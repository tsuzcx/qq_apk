package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class f$2$1
  implements com.tencent.mm.plugin.choosemsgfile.b.a.a
{
  f$2$1(f.2 param2, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv) {}
  
  public final void a(MsgFile paramMsgFile)
  {
    AppMethodBeat.i(54357);
    ab.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { this.kFy, paramMsgFile });
    f.a(this.kFL.kFK).il(this.kFy.kEz.field_msgId);
    f.a(this.kFL.kFK).a(this.kFy.kEz.field_msgId, paramMsgFile);
    if (f.a(this.kFL.kFK).bgB()) {
      al.d(new f.2.1.1(this));
    }
    this.kFL.kFK.kFr.bgE();
    this.kFy.bgp();
    paramMsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)this.jiE).kha.getTag();
    if (paramMsgFile.equals(this.kFy)) {
      paramMsgFile.T(this.jiE);
    }
    AppMethodBeat.o(54357);
  }
  
  public final void bgc()
  {
    AppMethodBeat.i(54358);
    ab.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", new Object[] { this.kFy });
    f.a(this.kFL.kFK).il(this.kFy.kEz.field_msgId);
    this.kFy.bgr();
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)this.jiE).kha.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54358);
  }
  
  public final void bgd()
  {
    AppMethodBeat.i(54359);
    ab.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", new Object[] { this.kFy });
    f.a(this.kFL.kFK).il(this.kFy.kEz.field_msgId);
    this.kFy.bgs();
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)this.jiE).kha.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54359);
  }
  
  public final void bge()
  {
    AppMethodBeat.i(54360);
    ab.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", new Object[] { this.kFy });
    f.a(this.kFL.kFK).il(this.kFy.kEz.field_msgId);
    this.kFy.bgq();
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)this.jiE).kha.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54360);
  }
  
  public final void dT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54361);
    ab.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { this.kFy, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.kFy.dV(paramInt1, paramInt2);
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)this.jiE).kha.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f.2.1
 * JD-Core Version:    0.7.0.1
 */