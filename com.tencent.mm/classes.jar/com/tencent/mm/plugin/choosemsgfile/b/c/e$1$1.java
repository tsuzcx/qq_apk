package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$1$1
  implements com.tencent.mm.plugin.choosemsgfile.b.a.a
{
  e$1$1(e.1 param1, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv) {}
  
  public final void a(MsgFile paramMsgFile)
  {
    AppMethodBeat.i(54339);
    ab.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { this.kFy, paramMsgFile });
    e.a(this.kFz.kFx).il(this.kFy.kEz.field_msgId);
    e.a(this.kFz.kFx).a(this.kFy.kEz.field_msgId, paramMsgFile);
    if (e.a(this.kFz.kFx).bgB()) {
      al.d(new e.1.1.1(this));
    }
    this.kFz.kFx.kFr.bgE();
    this.kFy.bgp();
    paramMsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)this.jiE).kFc.getTag();
    if (paramMsgFile.equals(this.kFy)) {
      paramMsgFile.T(this.jiE);
    }
    AppMethodBeat.o(54339);
  }
  
  public final void bgc()
  {
    AppMethodBeat.i(54340);
    ab.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", new Object[] { this.kFy });
    e.a(this.kFz.kFx).il(this.kFy.kEz.field_msgId);
    this.kFy.bgr();
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)this.jiE).kFc.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54340);
  }
  
  public final void bgd()
  {
    AppMethodBeat.i(54341);
    ab.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", new Object[] { this.kFy });
    e.a(this.kFz.kFx).il(this.kFy.kEz.field_msgId);
    this.kFy.bgs();
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)this.jiE).kFc.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54341);
  }
  
  public final void bge()
  {
    AppMethodBeat.i(54342);
    ab.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", new Object[] { this.kFy });
    e.a(this.kFz.kFx).il(this.kFy.kEz.field_msgId);
    this.kFy.bgq();
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)this.jiE).kFc.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54342);
  }
  
  public final void dT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54343);
    ab.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { this.kFy, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.kFy.dV(paramInt1, paramInt2);
    com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)this.jiE).kFc.getTag();
    if (locala.equals(this.kFy)) {
      locala.T(this.jiE);
    }
    AppMethodBeat.o(54343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e.1.1
 * JD-Core Version:    0.7.0.1
 */