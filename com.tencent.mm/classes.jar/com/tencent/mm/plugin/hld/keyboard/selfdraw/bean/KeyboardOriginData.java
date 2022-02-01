package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginData;", "", "config", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "keyDefaultConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "keys", "", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;Ljava/util/List;)V", "getConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "setConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;)V", "getKeyDefaultConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "setKeyDefaultConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;)V", "getKeys", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KeyboardOriginData
{
  private KeyboardOriginConfig config;
  private KeyOriginData keyDefaultConfig;
  private List<? extends List<KeyOriginData>> keys;
  
  public KeyboardOriginData(KeyboardOriginConfig paramKeyboardOriginConfig, KeyOriginData paramKeyOriginData, List<? extends List<KeyOriginData>> paramList)
  {
    AppMethodBeat.i(313128);
    this.config = paramKeyboardOriginConfig;
    this.keyDefaultConfig = paramKeyOriginData;
    this.keys = paramList;
    AppMethodBeat.o(313128);
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
    AppMethodBeat.i(313186);
    s.u(paramKeyboardOriginConfig, "config");
    s.u(paramKeyOriginData, "keyDefaultConfig");
    s.u(paramList, "keys");
    paramKeyboardOriginConfig = new KeyboardOriginData(paramKeyboardOriginConfig, paramKeyOriginData, paramList);
    AppMethodBeat.o(313186);
    return paramKeyboardOriginConfig;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313203);
    if (this == paramObject)
    {
      AppMethodBeat.o(313203);
      return true;
    }
    if (!(paramObject instanceof KeyboardOriginData))
    {
      AppMethodBeat.o(313203);
      return false;
    }
    paramObject = (KeyboardOriginData)paramObject;
    if (!s.p(this.config, paramObject.config))
    {
      AppMethodBeat.o(313203);
      return false;
    }
    if (!s.p(this.keyDefaultConfig, paramObject.keyDefaultConfig))
    {
      AppMethodBeat.o(313203);
      return false;
    }
    if (!s.p(this.keys, paramObject.keys))
    {
      AppMethodBeat.o(313203);
      return false;
    }
    AppMethodBeat.o(313203);
    return true;
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
    AppMethodBeat.i(313198);
    int i = this.config.hashCode();
    int j = this.keyDefaultConfig.hashCode();
    int k = this.keys.hashCode();
    AppMethodBeat.o(313198);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void setConfig(KeyboardOriginConfig paramKeyboardOriginConfig)
  {
    AppMethodBeat.i(313143);
    s.u(paramKeyboardOriginConfig, "<set-?>");
    this.config = paramKeyboardOriginConfig;
    AppMethodBeat.o(313143);
  }
  
  public final void setKeyDefaultConfig(KeyOriginData paramKeyOriginData)
  {
    AppMethodBeat.i(313155);
    s.u(paramKeyOriginData, "<set-?>");
    this.keyDefaultConfig = paramKeyOriginData;
    AppMethodBeat.o(313155);
  }
  
  public final void setKeys(List<? extends List<KeyOriginData>> paramList)
  {
    AppMethodBeat.i(313167);
    s.u(paramList, "<set-?>");
    this.keys = paramList;
    AppMethodBeat.o(313167);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(313192);
    String str = "KeyboardOriginData(config=" + this.config + ", keyDefaultConfig=" + this.keyDefaultConfig + ", keys=" + this.keys + ')';
    AppMethodBeat.o(313192);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardOriginData
 * JD-Core Version:    0.7.0.1
 */