package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderAccountManagementPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "config", "Lcom/tencent/mm/protocal/protobuf/AcctConfig;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;)V", "initContent", "", "onPrefClick", "plugin-finder_release"})
public final class a
  extends Preference
{
  public az wDE;
  
  public a(az paramaz, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(256156);
    setLayoutResource(2131495538);
    this.wDE = paramaz;
    paramaz = this.wDE;
    if (paramaz != null)
    {
      paramaz = paramaz.KDX;
      if (paramaz != null)
      {
        paramaz = (CharSequence)paramaz;
        setTitle(paramaz);
        paramaz = this.wDE;
        if (paramaz == null) {
          break label98;
        }
      }
    }
    label98:
    for (int i = paramaz.hashCode();; i = 0)
    {
      setKey(String.valueOf(i));
      AppMethodBeat.o(256156);
      return;
      paramaz = (CharSequence)"";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.a
 * JD-Core Version:    0.7.0.1
 */