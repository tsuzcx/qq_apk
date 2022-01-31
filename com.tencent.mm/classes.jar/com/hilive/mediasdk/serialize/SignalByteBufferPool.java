package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public class SignalByteBufferPool
{
  public static AtomicReference<MshByteBufferPool> mSigByteBufferPool;
  
  static
  {
    AppMethodBeat.i(142931);
    mSigByteBufferPool = new AtomicReference(null);
    AppMethodBeat.o(142931);
  }
  
  public static void alloc()
  {
    try
    {
      AppMethodBeat.i(142929);
      if (mSigByteBufferPool.get() == null) {
        mSigByteBufferPool.set(new MshByteBufferPool());
      }
      AppMethodBeat.o(142929);
      return;
    }
    finally {}
  }
  
  public static MshByteBufferPool get()
  {
    AppMethodBeat.i(142930);
    MshByteBufferPool localMshByteBufferPool = (MshByteBufferPool)mSigByteBufferPool.get();
    AppMethodBeat.o(142930);
    return localMshByteBufferPool;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(142928);
      if (mSigByteBufferPool.get() != null)
      {
        ((MshByteBufferPool)mSigByteBufferPool.get()).clear();
        mSigByteBufferPool.set(null);
      }
      AppMethodBeat.o(142928);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.SignalByteBufferPool
 * JD-Core Version:    0.7.0.1
 */