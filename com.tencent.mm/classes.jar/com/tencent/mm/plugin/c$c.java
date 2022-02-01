package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterCgiPlugin$RequestProtoBufDelegate;", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "rawData", "", "([B)V", "op", "", "opCode", "objs", "", "", "(I[Ljava/lang/Object;)I", "toByteArray", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$c
  extends erp
{
  private final byte[] rawData;
  
  public c$c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(260487);
    this.rawData = paramArrayOfByte;
    AppMethodBeat.o(260487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260494);
    s.u(paramVarArgs, "objs");
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.BaseRequest != null) {
        paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;
      }
      int i = this.rawData.length;
      AppMethodBeat.o(260494);
      return paramInt + i;
    }
    paramInt = super.op(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(260494);
    return paramInt;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(260491);
    validate();
    byte[] arrayOfByte = new byte[computeSize()];
    i.a.a.c.a locala = new i.a.a.c.a(arrayOfByte);
    if (this.BaseRequest != null)
    {
      locala.qD(1, this.BaseRequest.computeSize());
      this.BaseRequest.writeFields(locala);
    }
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize());; i = 0)
    {
      System.arraycopy(this.rawData, 0, arrayOfByte, i, this.rawData.length);
      AppMethodBeat.o(260491);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.c.c
 * JD-Core Version:    0.7.0.1
 */