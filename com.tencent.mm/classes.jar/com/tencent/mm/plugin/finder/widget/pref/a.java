package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderAccountManagementPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "config", "Lcom/tencent/mm/protocal/protobuf/AcctConfig;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;)V", "initContent", "", "onPrefClick", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Preference
{
  public az HaX;
  
  public a(az paramaz, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(330646);
    setLayoutResource(e.f.mm_preference);
    this.HaX = paramaz;
    paramaz = this.HaX;
    if (paramaz == null)
    {
      paramaz = (CharSequence)"";
      setTitle(paramaz);
      paramaz = this.HaX;
      if (paramaz != null) {
        break label136;
      }
      paramaz = null;
      label65:
      paramContext = String.valueOf(paramaz);
      paramaz = paramContext;
      if (paramContext == null) {
        paramaz = "";
      }
      setKey(paramaz);
      paramaz = this.HaX;
      if (paramaz != null) {
        break label147;
      }
      paramaz = (CharSequence)"";
    }
    for (;;)
    {
      aS(paramaz);
      AppMethodBeat.o(330646);
      return;
      paramaz = paramaz.YBR;
      if (paramaz == null)
      {
        paramaz = (CharSequence)"";
        break;
      }
      paramaz = (CharSequence)paramaz;
      break;
      label136:
      paramaz = Integer.valueOf(paramaz.hashCode());
      break label65;
      label147:
      paramaz = paramaz.YBT;
      if (paramaz == null) {
        paramaz = (CharSequence)"";
      } else {
        paramaz = (CharSequence)paramaz;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.a
 * JD-Core Version:    0.7.0.1
 */