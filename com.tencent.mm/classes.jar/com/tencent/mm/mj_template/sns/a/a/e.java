package com.tencent.mm.mj_template.sns.a.a;

import android.util.ArrayMap;
import androidx.compose.runtime.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.protocal.protobuf.fxr;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "", "dataId", "", "selectedState", "Landroidx/compose/runtime/MutableState;", "", "selectable", "(Ljava/lang/String;Landroidx/compose/runtime/MutableState;Z)V", "getDataId", "()Ljava/lang/String;", "getSelectable", "()Z", "getSelectedState", "()Landroidx/compose/runtime/MutableState;", "Companion", "SnsTemplateListDataDivider", "SnsTemplateListDataMiaoJian", "SnsTemplateListDataMore", "SnsTemplateListDataTemplate", "SnsTemplateListLoading", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataMore;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataMiaoJian;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataDivider;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListLoading;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
{
  public static final e.a oeM = new e.a((byte)0);
  private static int oeO;
  public final String hIQ;
  final boolean nXg;
  public final an<Boolean> oeN;
  
  private e(String paramString, an<Boolean> paraman, boolean paramBoolean)
  {
    this.hIQ = paramString;
    this.oeN = paraman;
    this.nXg = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataDivider;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e
  {
    public b()
    {
      super(null, false, 6);
      AppMethodBeat.i(240364);
      AppMethodBeat.o(240364);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataMiaoJian;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e
  {
    public static final c oeP;
    
    static
    {
      AppMethodBeat.i(240373);
      oeP = new c();
      AppMethodBeat.o(240373);
    }
    
    private c()
    {
      super(null, false, 2);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataMore;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e
  {
    public static final d oeQ;
    
    static
    {
      AppMethodBeat.i(240378);
      oeQ = new d();
      AppMethodBeat.o(240378);
    }
    
    private d()
    {
      super(null, false, 2);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "dataId", "", "name", "thumbnailUrl", "iosMinSdkVersion", "", "androidSdkVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getAndroidSdkVersion", "()J", "getIosMinSdkVersion", "getName", "()Ljava/lang/String;", "getThumbnailUrl", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends e
  {
    public static final a oeR;
    private static final ArrayMap<String, e> oeV;
    final String name;
    final String oeS;
    public final long oeT;
    public final long oeU;
    
    static
    {
      AppMethodBeat.i(240408);
      oeR = new a((byte)0);
      oeV = new ArrayMap();
      AppMethodBeat.o(240408);
    }
    
    private e(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
    {
      super(null, false, 6);
      this.name = paramString2;
      this.oeS = paramString3;
      this.oeT = paramLong1;
      this.oeU = paramLong2;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate$Companion;", "", "()V", "cachePool", "Landroid/util/ArrayMap;", "", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "fromMJTemplate", "template", "Lcom/tencent/maas/model/MJTemplateInfo;", "fromVideoTemplate", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "getInstance", "dataId", "name", "thumbnailUrl", "iosMinSdkVersion", "", "androidMinSdkVersion", "release", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static e.e a(fxr paramfxr)
      {
        int j = 0;
        AppMethodBeat.i(240413);
        s.u(paramfxr, "template");
        String str = paramfxr.id;
        s.s(str, "template.id");
        Object localObject1 = paramfxr.abVq;
        Object localObject2;
        label56:
        Object localObject3;
        label69:
        long l;
        if (localObject1 == null)
        {
          localObject1 = "";
          localObject2 = paramfxr.abVq;
          if (localObject2 != null) {
            break label126;
          }
          localObject2 = "";
          localObject3 = paramfxr.aahY;
          if (localObject3 != null) {
            break label149;
          }
          i = 0;
          l = i;
          paramfxr = paramfxr.aahY;
          if (paramfxr != null) {
            break label158;
          }
        }
        label149:
        label158:
        for (int i = j;; i = paramfxr.abME)
        {
          paramfxr = a(str, (String)localObject1, (String)localObject2, l, i);
          AppMethodBeat.o(240413);
          return paramfxr;
          localObject2 = ((aex)localObject1).title;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "";
          break;
          label126:
          localObject3 = ((aex)localObject2).ZmV;
          localObject2 = localObject3;
          if (localObject3 != null) {
            break label56;
          }
          localObject2 = "";
          break label56;
          i = ((fxe)localObject3).abMC;
          break label69;
        }
      }
      
      public static e.e a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(240405);
        s.u(paramString1, "dataId");
        s.u(paramString2, "name");
        s.u(paramString3, "thumbnailUrl");
        if (!e.e.byB().containsKey(paramString1)) {
          ((Map)e.e.byB()).put(paramString1, new e.e(paramString1, paramString2, paramString3, paramLong1, paramLong2, (byte)0));
        }
        paramString1 = e.e.byB().get(paramString1);
        s.checkNotNull(paramString1);
        s.s(paramString1, "cachePool[dataId]!!");
        paramString1 = (e.e)paramString1;
        AppMethodBeat.o(240405);
        return paramString1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListLoading;", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "()V", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends e
  {
    public f()
    {
      super(null, false, 2);
      AppMethodBeat.i(240386);
      AppMethodBeat.o(240386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.a.e
 * JD-Core Version:    0.7.0.1
 */