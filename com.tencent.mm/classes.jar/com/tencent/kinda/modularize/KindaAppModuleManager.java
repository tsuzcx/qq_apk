package com.tencent.kinda.modularize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaAppModuleManager
{
  private List<KindaModule> moduleList;
  
  public KindaAppModuleManager()
  {
    AppMethodBeat.i(141548);
    this.moduleList = new ArrayList();
    AppMethodBeat.o(141548);
  }
  
  public void initAllModule()
  {
    AppMethodBeat.i(141550);
    Iterator localIterator = this.moduleList.iterator();
    while (localIterator.hasNext())
    {
      KindaModule localKindaModule = (KindaModule)localIterator.next();
      localKindaModule.configModule();
      localKindaModule.initModuleInner();
    }
    AppMethodBeat.o(141550);
  }
  
  public void onAppCreate()
  {
    AppMethodBeat.i(141551);
    Iterator localIterator = this.moduleList.iterator();
    while (localIterator.hasNext()) {
      ((KindaModule)localIterator.next()).onAppCreate();
    }
    AppMethodBeat.o(141551);
  }
  
  public void registerModule(KindaModule paramKindaModule)
  {
    AppMethodBeat.i(141549);
    if (paramKindaModule != null) {
      this.moduleList.add(paramKindaModule);
    }
    AppMethodBeat.o(141549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.modularize.KindaAppModuleManager
 * JD-Core Version:    0.7.0.1
 */