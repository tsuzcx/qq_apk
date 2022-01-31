package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class HPMarshaller
  extends Marshallable
{
  public MshBuffer mMshBuffer = null;
  
  public HPMarshaller()
  {
    super(false);
  }
  
  public HPMarshaller(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public byte[] HPmarshall(MshBuffer paramMshBuffer)
  {
    AppMethodBeat.i(142856);
    this.mMshBuffer = paramMshBuffer;
    this.mBuffer = this.mMshBuffer.getByteBuffer();
    paramMshBuffer = marshall();
    AppMethodBeat.o(142856);
    return paramMshBuffer;
  }
  
  public MshBuffer getMshBuffer()
  {
    return this.mMshBuffer;
  }
  
  protected void increase_capacity(int paramInt)
  {
    AppMethodBeat.i(142859);
    this.mMshBuffer.increase_capacity(paramInt);
    this.mBuffer = this.mMshBuffer.getByteBuffer();
    AppMethodBeat.o(142859);
  }
  
  public void popMarshallable(MshBuffer paramMshBuffer)
  {
    AppMethodBeat.i(142858);
    this.mMshBuffer = paramMshBuffer;
    this.mBuffer = this.mMshBuffer.getByteBuffer();
    unmarshall(this.mBuffer);
    AppMethodBeat.o(142858);
  }
  
  public void pushMarshallable(MshBuffer paramMshBuffer)
  {
    AppMethodBeat.i(142857);
    this.mMshBuffer = paramMshBuffer;
    this.mBuffer = this.mMshBuffer.getByteBuffer();
    marshall(this.mBuffer);
    AppMethodBeat.o(142857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.HPMarshaller
 * JD-Core Version:    0.7.0.1
 */