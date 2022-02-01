package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginData;", "", "config", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "keyDefaultConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "keys", "", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;Ljava/util/List;)V", "getConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "setConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;)V", "getKeyDefaultConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "setKeyDefaultConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;)V", "getKeys", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-hld_release"})
public final class KeyboardOriginData
{
  private KeyboardOriginConfig config;
  private KeyOriginData keyDefaultConfig;
  private List<? extends List<KeyOriginData>> keys;
  
  public KeyboardOriginData(KeyboardOriginConfig paramKeyboardOriginConfig, KeyOriginData paramKeyOriginData, List<? extends List<KeyOriginData>> paramList)
  {
    AppMethodBeat.i(211006);
    this.config = paramKeyboardOriginConfig;
    this.keyDefaultConfig = paramKeyOriginData;
    this.keys = paramList;
    AppMethodBeat.o(211006);
  }
  
  public final KeyboardOriginConfig component1()
  {
    return this.config;
  }
  
  public final KeyOriginData component2()
  {
    return this.keyDefaultConfig;
  }
  
  public final List<List<KeyOriginData>> component3()
  {
    return this.keys;
  }
  
  public final KeyboardOriginData copy(KeyboardOriginConfig paramKeyboardOriginConfig, KeyOriginData paramKeyOriginData, List<? extends List<KeyOriginData>> paramList)
  {
    AppMethodBeat.i(211011);
    p.k(paramKeyboardOriginConfig, "config");
    p.k(paramKeyOriginData, "keyDefaultConfig");
    p.k(paramList, "keys");
    paramKeyboardOriginConfig = new KeyboardOriginData(paramKeyboardOriginConfig, paramKeyOriginData, paramList);
    AppMethodBeat.o(211011);
    return paramKeyboardOriginConfig;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(211020);
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyboardOriginData))
      {
        paramObject = (KeyboardOriginData)paramObject;
        if ((!p.h(this.config, paramObject.config)) || (!p.h(this.keyDefaultConfig, paramObject.keyDefaultConfig)) || (!p.h(this.keys, paramObject.keys))) {}
      }
    }
    else
    {
      AppMethodBeat.o(211020);
      return true;
    }
    AppMethodBeat.o(211020);
    return false;
  }
  
  public final KeyboardOriginConfig getConfig()
  {
    return this.config;
  }
  
  public final KeyOriginData getKeyDefaultConfig()
  {
    return this.keyDefaultConfig;
  }
  
  public final List<List<KeyOriginData>> getKeys()
  {
    return this.keys;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(211019);
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
      AppMethodBeat.o(211019);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void setConfig(KeyboardOriginConfig paramKeyboardOriginConfig)
  {
    AppMethodBeat.i(210999);
    p.k(paramKeyboardOriginConfig, "<set-?>");
    this.config = paramKeyboardOriginConfig;
    AppMethodBeat.o(210999);
  }
  
  public final void setKeyDefaultConfig(KeyOriginData paramKeyOriginData)
  {
    AppMethodBeat.i(211002);
    p.k(paramKeyOriginData, "<set-?>");
    this.keyDefaultConfig = paramKeyOriginData;
    AppMethodBeat.o(211002);
  }
  
  public final void setKeys(List<? extends List<KeyOriginData>> paramList)
  {
    AppMethodBeat.i(211004);
    p.k(paramList, "<set-?>");
    this.keys = paramList;
    AppMethodBeat.o(211004);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211018);
    String str = "KeyboardOriginData(config=" + this.config + ", keyDefaultConfig=" + this.keyDefaultConfig + ", keys=" + this.keys + ")";
    AppMethodBeat.o(211018);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardOriginData
 * JD-Core Version:    0.7.0.1
 */