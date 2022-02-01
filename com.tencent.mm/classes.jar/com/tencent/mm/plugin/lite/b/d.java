package com.tencent.mm.plugin.lite.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;

public final class d
  extends IListener<je>
{
  public d()
  {
    AppMethodBeat.i(198858);
    this.__eventId = je.class.getName().hashCode();
    AppMethodBeat.o(198858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.d
 * JD-Core Version:    0.7.0.1
 */