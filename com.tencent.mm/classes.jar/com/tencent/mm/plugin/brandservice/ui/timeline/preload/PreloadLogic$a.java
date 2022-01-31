package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import java.io.IOException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "save", "", "plugin-brandservice_release"})
public final class PreloadLogic$a
{
  private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
  
  private final boolean c(eh parameh, int paramInt)
  {
    AppMethodBeat.i(14862);
    if (parameh == null)
    {
      ab.v(this.TAG, "checkValid: null");
      AppMethodBeat.o(14862);
      return false;
    }
    Object localObject = PreloadLogic.kbJ;
    if (!PreloadLogic.b(parameh, paramInt))
    {
      ab.v(this.TAG, "checkValid: invalid version:data(" + parameh.wql + ')');
      AppMethodBeat.o(14862);
      return false;
    }
    localObject = g.kbz;
    if (g.a.aXw()) {
      ab.i(this.TAG, "checkValid: debug to expire");
    }
    for (;;)
    {
      AppMethodBeat.o(14862);
      return true;
      localObject = parameh.Url;
      j.p(localObject, "appMsgContext.Url");
      localObject = b.GS((String)localObject);
      as localas = b.GT((String)localObject);
      if (localas != null) {}
      for (boolean bool = d.a(localas, (String)localObject, parameh.wqh * 1000L); bool; bool = true)
      {
        ab.i(this.TAG, "checkValid: expire for " + parameh.wqh);
        AppMethodBeat.o(14862);
        return false;
      }
    }
  }
  
  public final eh GX(String paramString)
  {
    AppMethodBeat.i(14861);
    j.q(paramString, "url");
    String str = b.GQ(paramString);
    Object localObject = b.GT(str);
    if (localObject != null)
    {
      eh localeh = new eh();
      localObject = ((as)localObject).decodeBytes(str);
      try
      {
        localeh.parseFrom((byte[])localObject);
        localeh.Url = paramString;
        ab.i(this.TAG, "found:" + str + " last modify:" + localeh.wqj);
        AppMethodBeat.o(14861);
        return localeh;
      }
      catch (IOException paramString)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)paramString, "get:".concat(String.valueOf(str)), new Object[0]);
      }
    }
    ab.i(this.TAG, "not found:".concat(String.valueOf(str)));
    AppMethodBeat.o(14861);
    return null;
  }
  
  public final void a(String paramString, eh parameh)
  {
    Object localObject = null;
    AppMethodBeat.i(14863);
    j.q(paramString, "url");
    if (parameh == null)
    {
      ab.e(this.TAG, "save fail, appMsgContext is null");
      AppMethodBeat.o(14863);
      return;
    }
    str1 = b.GQ(paramString);
    long l = b.aXd();
    as localas = b.hU(l);
    String str2 = parameh.ntu;
    try
    {
      byte[] arrayOfByte = parameh.toByteArray();
      localObject = arrayOfByte;
      eh localeh = new eh();
      localObject = arrayOfByte;
      localeh.parseFrom(arrayOfByte);
      localObject = arrayOfByte;
      localeh.ntu = null;
      localObject = arrayOfByte;
      arrayOfByte = localeh.toByteArray();
      localObject = arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)localIOException, "save ".concat(String.valueOf(str1)), new Object[0]);
      }
    }
    if (localObject != null)
    {
      localas.encode(str1, localObject);
      if (str2 != null) {
        localas.putString(b.GR(paramString), str2);
      }
      d.a(localas, b.GS(paramString));
    }
    ab.i(this.TAG, "saveInfo " + str1 + " to slot#" + l + " last modify:" + parameh.wqj);
    AppMethodBeat.o(14863);
  }
  
  public final boolean bM(String paramString, int paramInt)
  {
    AppMethodBeat.i(14860);
    j.q(paramString, "url");
    eh localeh = GX(paramString);
    if (localeh == null)
    {
      AppMethodBeat.o(14860);
      return false;
    }
    Object localObject = PreloadLogic.kbJ;
    int i;
    if (localeh != null)
    {
      localObject = Integer.valueOf(localeh.wqp);
      i = PreloadLogic.sm(((Integer)localObject).intValue());
      if (i != -1) {
        break label121;
      }
    }
    for (;;)
    {
      boolean bool = c(localeh, paramInt);
      if (!bool) {
        ab.d(this.TAG, "init invalid:" + b.GQ(paramString));
      }
      AppMethodBeat.o(14860);
      return bool;
      localObject = null;
      break;
      label121:
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.a
 * JD-Core Version:    0.7.0.1
 */