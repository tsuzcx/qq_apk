package com.bumptech.glide;

import com.bumptech.glide.f.b.a;
import com.bumptech.glide.f.b.c;

public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType>
  implements Cloneable
{
  c<? super TranscodeType> aDz = a.qn();
  
  public final CHILD nP()
  {
    try
    {
      k localk = (k)super.clone();
      return localk;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.k
 * JD-Core Version:    0.7.0.1
 */