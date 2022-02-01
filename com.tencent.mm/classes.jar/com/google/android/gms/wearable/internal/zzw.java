package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class zzw
  implements CapabilityInfo
{
  private final String name;
  private final Set<Node> zzbt;
  
  public zzw(CapabilityInfo paramCapabilityInfo)
  {
    this(paramCapabilityInfo.getName(), paramCapabilityInfo.getNodes());
    AppMethodBeat.i(101459);
    AppMethodBeat.o(101459);
  }
  
  private zzw(String paramString, Set<Node> paramSet)
  {
    this.name = paramString;
    this.zzbt = paramSet;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final Set<Node> getNodes()
  {
    return this.zzbt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzw
 * JD-Core Version:    0.7.0.1
 */