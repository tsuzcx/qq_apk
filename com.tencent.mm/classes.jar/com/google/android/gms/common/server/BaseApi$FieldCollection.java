package com.google.android.gms.common.server;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseApi$FieldCollection<Parent>
{
  private final BaseApi.BaseApiaryOptions<?>.Collector zzvw;
  private final Parent zzwc;
  
  protected BaseApi$FieldCollection(Parent paramParent, BaseApi.BaseApiaryOptions<?>.Collector paramBaseApiaryOptions)
  {
    AppMethodBeat.i(11923);
    Object localObject = paramParent;
    if (paramParent == null) {
      localObject = this;
    }
    this.zzwc = localObject;
    this.zzvw = paramBaseApiaryOptions;
    AppMethodBeat.o(11923);
  }
  
  protected BaseApi.BaseApiaryOptions<?>.Collector getCollector()
  {
    return this.zzvw;
  }
  
  protected Parent getParent()
  {
    return this.zzwc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.server.BaseApi.FieldCollection
 * JD-Core Version:    0.7.0.1
 */