package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "", "config", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "keyDefaultConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "keys", "", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;Ljava/util/List;)V", "getConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "setConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;)V", "getKeyDefaultConfig", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "setKeyDefaultConfig", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;)V", "getKeys", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "deepCopy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KeyboardData
{
  private KeyboardConfig config;
  private KeyData keyDefaultConfig;
  private List<? extends List<KeyData>> keys;
  
  public KeyboardData(KeyboardConfig paramKeyboardConfig, KeyData paramKeyData, List<? extends List<KeyData>> paramList)
  {
    AppMethodBeat.i(313123);
    this.config = paramKeyboardConfig;
    this.keyDefaultConfig = paramKeyData;
    this.keys = paramList;
    AppMethodBeat.o(313123);
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
    AppMethodBeat.i(313187);
    s.u(paramKeyboardConfig, "config");
    s.u(paramKeyData, "keyDefaultConfig");
    s.u(paramList, "keys");
    paramKeyboardConfig = new KeyboardData(paramKeyboardConfig, paramKeyData, paramList);
    AppMethodBeat.o(313187);
    return paramKeyboardConfig;
  }
  
  public final KeyboardData deepCopy()
  {
    AppMethodBeat.i(313169);
    Object localObject1 = this.config;
    Object localObject2 = this.config.getLine();
    int i;
    int j;
    label39:
    float f;
    if (localObject2 == null)
    {
      i = 0;
      localObject2 = new ArrayList(i);
      j = 0;
      if (j >= i) {
        break label118;
      }
      localObject3 = getConfig().getLineHeight();
      if (localObject3 != null) {
        break label86;
      }
      f = 0.0F;
    }
    for (;;)
    {
      ((ArrayList)localObject2).add(Float.valueOf(f));
      j += 1;
      break label39;
      i = ((Integer)localObject2).intValue();
      break;
      label86:
      localObject3 = (Float)((List)localObject3).get(j);
      if (localObject3 == null) {
        f = 0.0F;
      } else {
        f = ((Float)localObject3).floatValue();
      }
    }
    label118:
    localObject1 = KeyboardConfig.copy$default((KeyboardConfig)localObject1, null, null, null, (List)localObject2, null, null, null, null, null, null, null, null, 4087, null);
    localObject2 = KeyData.copy$default(this.keyDefaultConfig, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
    Object localObject3 = (List)new ArrayList();
    Object localObject4 = ((Iterable)getKeys()).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (List)((Iterator)localObject4).next();
      List localList = (List)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        localList.add(KeyData.copy$default((KeyData)((Iterator)localObject5).next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null));
      }
      ((List)localObject3).add(localList);
    }
    localObject4 = ah.aiuX;
    localObject1 = new KeyboardData((KeyboardConfig)localObject1, (KeyData)localObject2, (List)localObject3);
    AppMethodBeat.o(313169);
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313204);
    if (this == paramObject)
    {
      AppMethodBeat.o(313204);
      return true;
    }
    if (!(paramObject instanceof KeyboardData))
    {
      AppMethodBeat.o(313204);
      return false;
    }
    paramObject = (KeyboardData)paramObject;
    if (!s.p(this.config, paramObject.config))
    {
      AppMethodBeat.o(313204);
      return false;
    }
    if (!s.p(this.keyDefaultConfig, paramObject.keyDefaultConfig))
    {
      AppMethodBeat.o(313204);
      return false;
    }
    if (!s.p(this.keys, paramObject.keys))
    {
      AppMethodBeat.o(313204);
      return false;
    }
    AppMethodBeat.o(313204);
    return true;
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
    AppMethodBeat.i(313199);
    int i = this.config.hashCode();
    int j = this.keyDefaultConfig.hashCode();
    int k = this.keys.hashCode();
    AppMethodBeat.o(313199);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void setConfig(KeyboardConfig paramKeyboardConfig)
  {
    AppMethodBeat.i(313132);
    s.u(paramKeyboardConfig, "<set-?>");
    this.config = paramKeyboardConfig;
    AppMethodBeat.o(313132);
  }
  
  public final void setKeyDefaultConfig(KeyData paramKeyData)
  {
    AppMethodBeat.i(313142);
    s.u(paramKeyData, "<set-?>");
    this.keyDefaultConfig = paramKeyData;
    AppMethodBeat.o(313142);
  }
  
  public final void setKeys(List<? extends List<KeyData>> paramList)
  {
    AppMethodBeat.i(313153);
    s.u(paramList, "<set-?>");
    this.keys = paramList;
    AppMethodBeat.o(313153);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(313195);
    String str = "KeyboardData(config=" + this.config + ", keyDefaultConfig=" + this.keyDefaultConfig + ", keys=" + this.keys + ')';
    AppMethodBeat.o(313195);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData
 * JD-Core Version:    0.7.0.1
 */