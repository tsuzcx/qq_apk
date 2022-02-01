package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.d.a.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper;", "", "()V", "ChoiceItem", "Companion", "DebugBoxPref", "DebugChoicePref", "DebugClickPref", "IPreferenceEvent", "plugin-finder_release"})
public final class h
{
  public static final b Axb;
  
  static
  {
    AppMethodBeat.i(271697);
    Axb = new b((byte)0);
    AppMethodBeat.o(271697);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "_items", "", "", "getActivity", "()Landroid/app/Activity;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "value", "getValue", "()Ljava/lang/String;", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "plugin-finder_release"})
  public static final class a
  {
    List<String> Axc;
    final e Axd;
    private final Activity activity;
    
    public a(Activity paramActivity, e parame)
    {
      AppMethodBeat.i(278301);
      this.activity = paramActivity;
      this.Axd = parame;
      this.Axc = this.Axd.enw();
      AppMethodBeat.o(278301);
    }
    
    public final String getValue()
    {
      AppMethodBeat.i(278300);
      int i = this.Axd.BwA;
      Object localObject = this.Axc;
      if (localObject != null)
      {
        if ((i >= 0) && (i < ((List)localObject).size()))
        {
          localObject = (String)((List)localObject).get(i);
          AppMethodBeat.o(278300);
          return localObject;
        }
        localObject = this.Axd.enx();
        AppMethodBeat.o(278300);
        return localObject;
      }
      AppMethodBeat.o(278300);
      return "";
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements com.tencent.mm.ui.base.h.e
    {
      a(h.a parama, h.f paramf, MMPreference paramMMPreference) {}
      
      public final void cS(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(245566);
        try
        {
          this.Axe.Axd.Si(paramInt1);
          this.Axf.bfU();
          this.Axg.getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(245566);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("SettingHelper", (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(245566);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$Companion;", "", "()V", "TAG", "", "VERSION_TAG", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
  public static final class c
    extends CheckBoxPreference
    implements h.f
  {
    private final e Axd;
    private final MMPreference Axh;
    
    public c(MMPreference paramMMPreference, e parame)
    {
      super();
      AppMethodBeat.i(272011);
      this.Axh = paramMMPreference;
      this.Axd = parame;
      paramMMPreference = this.Axd.eny();
      if (paramMMPreference == null)
      {
        paramMMPreference = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(272011);
        throw paramMMPreference;
      }
      paramMMPreference = paramMMPreference.toUpperCase();
      p.j(paramMMPreference, "(this as java.lang.String).toUpperCase()");
      if (paramMMPreference.compareTo("2021T1") >= 0)
      {
        paramMMPreference = (CharSequence)("🌟" + this.Axd.title);
        setTitle(paramMMPreference);
        setKey(this.Axd.title);
        if (this.Axd.BwA != 1) {
          break label180;
        }
      }
      label180:
      for (boolean bool = true;; bool = false)
      {
        setChecked(bool);
        this.Axh.getPreferenceScreen().b((Preference)this);
        AppMethodBeat.o(272011);
        return;
        paramMMPreference = (CharSequence)this.Axd.title;
        break;
      }
    }
    
    public final void bfU()
    {
      boolean bool = true;
      AppMethodBeat.i(272009);
      if (this.Axd.BwA == 1) {}
      for (;;)
      {
        setChecked(bool);
        AppMethodBeat.o(272009);
        return;
        bool = false;
      }
    }
    
    public final void ebl()
    {
      AppMethodBeat.i(272010);
      Object localObject = "doSomething " + getTitle() + " isChecked: " + isChecked();
      Log.i("SettingHelper", (String)localObject);
      w.makeText((Context)this.Axh, (CharSequence)localObject, 1).show();
      localObject = this.Axd;
      if (isChecked()) {}
      for (int i = 1;; i = 0)
      {
        ((e)localObject).Si(i);
        bfU();
        AppMethodBeat.o(272010);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;)V", "doSomething", "", "refresh", "plugin-finder_release"})
  public static final class d
    extends Preference
    implements h.f
  {
    private final e Axd;
    private final MMPreference Axh;
    private h.a Axi;
    
    public d(MMPreference paramMMPreference, e parame)
    {
      super();
      AppMethodBeat.i(282029);
      this.Axh = paramMMPreference;
      this.Axd = parame;
      this.Axi = new h.a((Activity)this.Axh, this.Axd);
      paramMMPreference = this.Axd.eny();
      if (paramMMPreference == null)
      {
        paramMMPreference = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(282029);
        throw paramMMPreference;
      }
      paramMMPreference = paramMMPreference.toUpperCase();
      p.j(paramMMPreference, "(this as java.lang.String).toUpperCase()");
      if (paramMMPreference.compareTo("2021T1") >= 0) {}
      for (paramMMPreference = (CharSequence)("🌟" + this.Axd.title);; paramMMPreference = (CharSequence)this.Axd.title)
      {
        setTitle(paramMMPreference);
        setKey(this.Axd.title);
        aF((CharSequence)String.valueOf(this.Axi.getValue()));
        this.Axh.getPreferenceScreen().b((Preference)this);
        AppMethodBeat.o(282029);
        return;
      }
    }
    
    public final void bfU()
    {
      AppMethodBeat.i(282027);
      aF((CharSequence)String.valueOf(this.Axi.getValue()));
      AppMethodBeat.o(282027);
    }
    
    public final void ebl()
    {
      AppMethodBeat.i(282028);
      h.a locala = this.Axi;
      MMPreference localMMPreference = this.Axh;
      h.f localf = (h.f)this;
      p.k(localMMPreference, "activity");
      p.k(localf, "operation");
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      List localList = locala.Axc;
      if (localList == null) {
        p.iCn();
      }
      int j = ((Collection)localList).size();
      int i = 0;
      while (i < j)
      {
        localList = locala.Axc;
        if (localList == null) {
          p.iCn();
        }
        localLinkedList1.add(localList.get(i));
        localLinkedList2.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)localMMPreference, "", (List)localLinkedList1, (List)localLinkedList2, "", (com.tencent.mm.ui.base.h.e)new h.a.a(locala, localf, localMMPreference));
      AppMethodBeat.o(282028);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
  public static final class e
    extends Preference
    implements h.f
  {
    private final e Axd;
    private final MMPreference Axh;
    
    public e(MMPreference paramMMPreference, e parame)
    {
      super();
      AppMethodBeat.i(285686);
      this.Axh = paramMMPreference;
      this.Axd = parame;
      paramMMPreference = this.Axd.eny();
      if (paramMMPreference == null)
      {
        paramMMPreference = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(285686);
        throw paramMMPreference;
      }
      paramMMPreference = paramMMPreference.toUpperCase();
      p.j(paramMMPreference, "(this as java.lang.String).toUpperCase()");
      if (paramMMPreference.compareTo("2021T1") >= 0) {}
      for (paramMMPreference = (CharSequence)("🌟" + this.Axd.title);; paramMMPreference = (CharSequence)this.Axd.title)
      {
        setTitle(paramMMPreference);
        setKey(this.Axd.title);
        this.Axh.getPreferenceScreen().b((Preference)this);
        AppMethodBeat.o(285686);
        return;
      }
    }
    
    public final void bfU() {}
    
    public final void ebl()
    {
      AppMethodBeat.i(285685);
      String str = "doSomething " + getTitle() + " onClick";
      Log.i("SettingHelper", str);
      w.makeText((Context)this.Axh, (CharSequence)str, 1).show();
      this.Axd.Si(0);
      AppMethodBeat.o(285685);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "", "doSomething", "", "refresh", "plugin-finder_release"})
  public static abstract interface f
  {
    public abstract void bfU();
    
    public abstract void ebl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.h
 * JD-Core Version:    0.7.0.1
 */