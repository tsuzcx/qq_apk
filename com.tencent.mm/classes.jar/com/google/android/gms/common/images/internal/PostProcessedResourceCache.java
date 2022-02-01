package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import androidx.b.e;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PostProcessedResourceCache
  extends e<PostProcessedResource, Drawable>
{
  public PostProcessedResourceCache()
  {
    super(10);
  }
  
  public static final class PostProcessedResource
  {
    public final int postProcessingFlags;
    public final int resId;
    
    public PostProcessedResource(int paramInt1, int paramInt2)
    {
      this.resId = paramInt1;
      this.postProcessingFlags = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof PostProcessedResource)) {}
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
        paramObject = (PostProcessedResource)paramObject;
      } while ((paramObject.resId != this.resId) || (paramObject.postProcessingFlags != this.postProcessingFlags));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(11788);
      int i = Objects.hashCode(new Object[] { Integer.valueOf(this.resId), Integer.valueOf(this.postProcessingFlags) });
      AppMethodBeat.o(11788);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.PostProcessedResourceCache
 * JD-Core Version:    0.7.0.1
 */