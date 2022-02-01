package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "", "config", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "keyDefaultConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "keys", "", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;Ljava/util/List;)V", "getConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "setConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;)V", "getKeyDefaultConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "setKeyDefaultConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;)V", "getKeys", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "deepCopy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-hld_release"})
public final class KeyboardData
{
  private KeyboardConfig config;
  private KeyData keyDefaultConfig;
  private List<? extends List<KeyData>> keys;
  
  public KeyboardData(KeyboardConfig paramKeyboardConfig, KeyData paramKeyData, List<? extends List<KeyData>> paramList)
  {
    AppMethodBeat.i(216766);
    this.config = paramKeyboardConfig;
    this.keyDefaultConfig = paramKeyData;
    this.keys = paramList;
    AppMethodBeat.o(216766);
  }
  
  public final KeyboardConfig component1()
  {
    return this.config;
  }
  
  public final KeyData component2()
  {
    return this.keyDefaultConfig;
  }
  
  public final List<List<KeyData>> component3()
  {
    return this.keys;
  }
  
  public final KeyboardData copy(KeyboardConfig paramKeyboardConfig, KeyData paramKeyData, List<? extends List<KeyData>> paramList)
  {
    AppMethodBeat.i(216768);
    p.k(paramKeyboardConfig, "config");
    p.k(paramKeyData, "keyDefaultConfig");
    p.k(paramList, "keys");
    paramKeyboardConfig = new KeyboardData(paramKeyboardConfig, paramKeyData, paramList);
    AppMethodBeat.o(216768);
    return paramKeyboardConfig;
  }
  
  public final KeyboardData deepCopy()
  {
    AppMethodBeat.i(216758);
    Object localObject1 = this.config;
    Object localObject2 = this.config.getLine();
    int i;
    int j;
    if (localObject2 != null)
    {
      i = ((Integer)localObject2).intValue();
      localObject2 = new ArrayList(i);
      j = 0;
      label43:
      if (j >= i) {
        break label113;
      }
      localObject3 = this.config.getLineHeight();
      if (localObject3 == null) {
        break label108;
      }
      localObject3 = (Float)((List)localObject3).get(j);
      if (localObject3 == null) {
        break label108;
      }
    }
    label108:
    for (float f = ((Float)localObject3).floatValue();; f = 0.0F)
    {
      ((ArrayList)localObject2).add(Float.valueOf(f));
      j += 1;
      break label43;
      i = 0;
      break;
    }
    label113:
    localObject1 = KeyboardConfig.copy$default((KeyboardConfig)localObject1, null, null, null, (List)localObject2, null, null, null, null, null, null, null, null, 4087, null);
    localObject2 = KeyData.copy$default(this.keyDefaultConfig, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
    Object localObject3 = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.keys).iterator();
    while (localIterator.hasNext())
    {
      Object localObject4 = (List)localIterator.next();
      List localList = (List)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        localList.add(KeyData.copy$default((KeyData)((Iterator)localObject4).next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null));
      }
      ((List)localObject3).add(localList);
    }
    localObject1 = new KeyboardData((KeyboardConfig)localObject1, (KeyData)localObject2, (List)localObject3);
    AppMethodBeat.o(216758);
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216772);
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyboardData))
      {
        paramObject = (KeyboardData)paramObject;
        if ((!p.h(this.config, paramObject.config)) || (!p.h(this.keyDefaultConfig, paramObject.keyDefaultConfig)) || (!p.h(this.keys, paramObject.keys))) {}
      }
    }
    else
    {
      AppMethodBeat.o(216772);
      return true;
    }
    AppMethodBeat.o(216772);
    return false;
  }
  
  public final KeyboardConfig getConfig()
  {
    return this.config;
  }
  
  public final KeyData getKeyDefaultConfig()
  {
    return this.keyDefaultConfig;
  }
  
  public final List<List<KeyData>> getKeys()
  {
    return this.keys;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(216771);
    Object localObject = this.config;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.keyDefaultConfig;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.keys;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(216771);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void setConfig(KeyboardConfig paramKeyboardConfig)
  {
    AppMethodBeat.i(216760);
    p.k(paramKeyboardConfig, "<set-?>");
    this.config = paramKeyboardConfig;
    AppMethodBeat.o(216760);
  }
  
  public final void setKeyDefaultConfig(KeyData paramKeyData)
  {
    AppMethodBeat.i(216762);
    p.k(paramKeyData, "<set-?>");
    this.keyDefaultConfig = paramKeyData;
    AppMethodBeat.o(216762);
  }
  
  public final void setKeys(List<? extends List<KeyData>> paramList)
  {
    AppMethodBeat.i(216764);
    p.k(paramList, "<set-?>");
    this.keys = paramList;
    AppMethodBeat.o(216764);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216770);
    String str = "KeyboardData(config=" + this.config + ", keyDefaultConfig=" + this.keyDefaultConfig + ", keys=" + this.keys + ")";
    AppMethodBeat.o(216770);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData
 * JD-Core Version:    0.7.0.1
 */