package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(16)
public final class g
  extends h
{
  private ArrayList<Integer> hcC;
  
  public g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramBoolean);
    AppMethodBeat.i(89472);
    this.hcC = new ArrayList();
    AppMethodBeat.o(89472);
  }
  
  public final int E(int paramInt, String paramString)
  {
    AppMethodBeat.i(89473);
    this.hcC.clear();
    this.hcC.add(Integer.valueOf(paramInt));
    paramInt = super.E(paramInt, paramString);
    AppMethodBeat.o(89473);
    return paramInt;
  }
  
  protected final void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89476);
    if ((this.hcC.size() > 0) && (paramByteBuffer != null) && (!this.uMH))
    {
      Iterator localIterator = this.hcC.iterator();
      while (localIterator.hasNext()) {
        SightVideoJNI.writeAACDataWithADTSLock(((Integer)localIterator.next()).intValue(), paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt1, paramInt2, paramInt3);
      }
    }
    AppMethodBeat.o(89476);
  }
  
  protected final boolean auZ()
  {
    return true;
  }
  
  protected final void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89475);
    if ((this.hcC.size() > 0) && (paramByteBuffer != null) && (!this.uMH))
    {
      Iterator localIterator = this.hcC.iterator();
      while (localIterator.hasNext()) {
        SightVideoJNI.writeAACDataLock(((Integer)localIterator.next()).intValue(), paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      }
    }
    AppMethodBeat.o(89475);
  }
  
  public final void nC(int paramInt)
  {
    AppMethodBeat.i(89474);
    this.hcC.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(89474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.g
 * JD-Core Version:    0.7.0.1
 */