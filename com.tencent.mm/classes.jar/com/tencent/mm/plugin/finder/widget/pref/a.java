package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/pref/FinderAccountManagementPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "config", "Lcom/tencent/mm/protocal/protobuf/AcctConfig;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Lcom/tencent/mm/protocal/protobuf/AcctConfig;Landroid/content/Context;)V", "initContent", "", "onPrefClick", "plugin-finder_release"})
public final class a
  extends Preference
{
  public ax Bum;
  
  public a(ax paramax, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(292259);
    setLayoutResource(b.g.mm_preference);
    this.Bum = paramax;
    paramax = this.Bum;
    if (paramax != null)
    {
      paramax = paramax.RFp;
      if (paramax != null)
      {
        paramax = (CharSequence)paramax;
        setTitle(paramax);
        paramax = this.Bum;
        if (paramax == null) {
          break label99;
        }
      }
    }
    label99:
    for (int i = paramax.hashCode();; i = 0)
    {
      setKey(String.valueOf(i));
      AppMethodBeat.o(292259);
      return;
      paramax = (CharSequence)"";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.pref.a
 * JD-Core Version:    0.7.0.1
 */