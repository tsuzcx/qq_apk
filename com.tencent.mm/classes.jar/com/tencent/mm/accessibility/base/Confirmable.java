package com.tencent.mm.accessibility.base;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/base/Confirmable;", "", "originConfig", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "(Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;)V", "confirm", "", "confirm$plugin_autoaccessibility_release", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class Confirmable
{
  public Confirmable(MMBaseAccessibilityConfig paramMMBaseAccessibilityConfig)
  {
    paramMMBaseAccessibilityConfig.getConfirmableList$plugin_autoaccessibility_release().add(this);
  }
  
  public abstract void confirm$plugin_autoaccessibility_release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.base.Confirmable
 * JD-Core Version:    0.7.0.1
 */