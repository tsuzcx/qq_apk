package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterCgiPlugin$ResponseProtoBufDelegate;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "()V", "rawData", "", "op", "", "opCode", "objs", "", "", "(I[Ljava/lang/Object;)I", "parseFrom", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data", "toByteArray", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$d
  extends esc
{
  private byte[] rawData;
  
  public c$d()
  {
    AppMethodBeat.i(260419);
    this.rawData = new byte[0];
    this.BaseResponse = new kd();
    AppMethodBeat.o(260419);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260430);
    s.u(paramVarArgs, "objs");
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.BaseResponse != null) {
        paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;
      }
      int i = this.rawData.length;
      AppMethodBeat.o(260430);
      return paramInt + i;
    }
    paramInt = super.op(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(260430);
    return paramInt;
  }
  
  public final com.tencent.mm.bx.a parseFrom(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this.rawData = arrayOfByte;
    return (com.tencent.mm.bx.a)this;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(260437);
    validate();
    byte[] arrayOfByte = new byte[computeSize()];
    i.a.a.c.a locala = new i.a.a.c.a(arrayOfByte);
    if (this.BaseResponse != null)
    {
      locala.qD(1, this.BaseResponse.computeSize());
      this.BaseResponse.writeFields(locala);
    }
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize());; i = 0)
    {
      System.arraycopy(this.rawData, 0, arrayOfByte, i, this.rawData.length);
      AppMethodBeat.o(260437);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.c.d
 * JD-Core Version:    0.7.0.1
 */