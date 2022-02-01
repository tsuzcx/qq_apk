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
    AppMethodBeat.i(136073);
    this.moduleList = new ArrayList();
    AppMethodBeat.o(136073);
  }
  
  public void initAllModule()
  {
    AppMethodBeat.i(136075);
    Iterator localIterator = this.moduleList.iterator();
    while (localIterator.hasNext())
    {
      KindaModule localKindaModule = (KindaModule)localIterator.next();
      localKindaModule.configModule();
      localKindaModule.initModuleInner();
    }
    AppMethodBeat.o(136075);
  }
  
  public void onAppCreate()
  {
    AppMethodBeat.i(136076);
    Iterator localIterator = this.moduleList.iterator();
    while (localIterator.hasNext()) {
      ((KindaModule)localIterator.next()).onAppCreate();
    }
    AppMethodBeat.o(136076);
  }
  
  public void registerModule(KindaModule paramKindaModule)
  {
    AppMethodBeat.i(136074);
    if (paramKindaModule != null) {
      this.moduleList.add(paramKindaModule);
    }
    AppMethodBeat.o(136074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.modularize.KindaAppModuleManager
 * JD-Core Version:    0.7.0.1
 */