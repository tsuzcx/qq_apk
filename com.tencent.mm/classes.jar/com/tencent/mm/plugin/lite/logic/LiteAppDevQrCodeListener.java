package com.tencent.mm.plugin.lite.logic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.lite.api.a;
import com.tencent.mm.plugin.lite.api.b;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;

public class LiteAppDevQrCodeListener
  extends IListener<kw>
{
  public LiteAppDevQrCodeListener()
  {
    super(f.hfK);
    AppMethodBeat.i(271353);
    this.__eventId = kw.class.getName().hashCode();
    AppMethodBeat.o(271353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.LiteAppDevQrCodeListener
 * JD-Core Version:    0.7.0.1
 */