package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.agz;

public final class i
{
  public static final class b
    extends l.e
    implements l.c
  {
    public agz mgN;
    
    public b()
    {
      AppMethodBeat.i(68);
      this.mgN = new agz();
      AppMethodBeat.o(68);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(69);
      this.mgN = ((agz)new agz().parseFrom(paramArrayOfByte));
      l.a(this, this.mgN.getBaseResponse());
      int i = this.mgN.getBaseResponse().Ret;
      AppMethodBeat.o(69);
      return i;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i
 * JD-Core Version:    0.7.0.1
 */