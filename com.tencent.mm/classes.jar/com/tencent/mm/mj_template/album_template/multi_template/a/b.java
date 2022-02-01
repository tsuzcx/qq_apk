package com.tencent.mm.mj_template.album_template.multi_template.a;

import androidx.compose.runtime.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "", "dataId", "", "selected", "Landroidx/compose/runtime/MutableState;", "", "selectable", "exposed", "(Ljava/lang/String;Landroidx/compose/runtime/MutableState;ZZ)V", "getDataId", "()Ljava/lang/String;", "getExposed", "()Z", "setExposed", "(Z)V", "getSelectable", "getSelected", "()Landroidx/compose/runtime/MutableState;", "Companion", "MMEditTemplate", "MaasBlankTemplate", "MaasLoading", "MaasTemplate", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasTemplate;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasLoading;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasBlankTemplate;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MMEditTemplate;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  public static final b.a nXe = new b.a((byte)0);
  private static int nXi;
  final String hIQ;
  final an<Boolean> nXf;
  final boolean nXg;
  boolean nXh;
  
  private b(String paramString, an<Boolean> paraman, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.hIQ = paramString;
    this.nXf = paraman;
    this.nXg = paramBoolean1;
    this.nXh = paramBoolean2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MMEditTemplate;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends b
  {
    public static final b nXj;
    
    static
    {
      AppMethodBeat.i(240691);
      nXj = new b();
      AppMethodBeat.o(240691);
    }
    
    private b()
    {
      super(null, false, true, 6);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasBlankTemplate;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends b
  {
    public static final c nXk;
    
    static
    {
      AppMethodBeat.i(240689);
      nXk = new c();
      AppMethodBeat.o(240689);
    }
    
    private c()
    {
      super(null, false, true, 6);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasLoading;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends b
  {
    public d()
    {
      super(null, false, true, 2);
      AppMethodBeat.i(240695);
      AppMethodBeat.o(240695);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasTemplate;", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "dataId", "", "thumbnailURL", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getThumbnailURL", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends b
  {
    final String displayName;
    final String thumbnailURL;
    
    public e(String paramString1, String paramString2, String paramString3)
    {
      super(null, false, false, 14);
      AppMethodBeat.i(240686);
      this.thumbnailURL = paramString2;
      this.displayName = paramString3;
      AppMethodBeat.o(240686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.a.b
 * JD-Core Version:    0.7.0.1
 */