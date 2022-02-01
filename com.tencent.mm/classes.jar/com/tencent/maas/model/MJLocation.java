package com.tencent.maas.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class MJLocation
{
  private final float latitude;
  private final float longitude;
  
  public MJLocation(float paramFloat1, float paramFloat2)
  {
    this.longitude = paramFloat1;
    this.latitude = paramFloat2;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216798);
    if (this == paramObject)
    {
      AppMethodBeat.o(216798);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(216798);
      return false;
    }
    paramObject = (MJLocation)paramObject;
    if ((Float.compare(paramObject.longitude, this.longitude) == 0) && (Float.compare(paramObject.latitude, this.latitude) == 0))
    {
      AppMethodBeat.o(216798);
      return true;
    }
    AppMethodBeat.o(216798);
    return false;
  }
  
  public float getLatitude()
  {
    return this.latitude;
  }
  
  public float getLongitude()
  {
    return this.longitude;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(216800);
    int i = Objects.hash(new Object[] { Integer.valueOf((int)(this.longitude * 100.0F)), Integer.valueOf((int)(this.latitude * 10.0F)) });
    AppMethodBeat.o(216800);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.maas.model.MJLocation
 * JD-Core Version:    0.7.0.1
 */