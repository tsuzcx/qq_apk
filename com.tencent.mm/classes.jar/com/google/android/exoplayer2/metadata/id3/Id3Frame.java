package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class Id3Frame
  implements Metadata.Entry
{
  public final String id;
  
  public Id3Frame(String paramString)
  {
    this.id = ((String)a.E(paramString));
  }
  
  public int describeContents()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.Id3Frame
 * JD-Core Version:    0.7.0.1
 */