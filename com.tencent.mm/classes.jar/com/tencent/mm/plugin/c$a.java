package com.tencent.mm.plugin;

import com.tencent.c.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterCgiPlugin$CgiDelegate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "flutterRequest", "Lcom/tencent/pigeon/FlutterCgiPigeon$FlutterCgiRequest;", "(Lcom/tencent/pigeon/FlutterCgiPigeon$FlutterCgiRequest;)V", "await", "Lcom/tencent/pigeon/FlutterCgiPigeon$FlutterCgiResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$a
  extends b<esc>
{
  public c$a(b.c paramc)
  {
    AppMethodBeat.i(260429);
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    byte[] arrayOfByte = paramc.data;
    s.s(arrayOfByte, "flutterRequest.data");
    locala.otE = ((a)new c.c(arrayOfByte));
    locala.otF = ((a)new c.d());
    locala.funcId = ((int)paramc.ahhv.longValue());
    locala.uri = paramc.uri;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    AppMethodBeat.o(260429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */