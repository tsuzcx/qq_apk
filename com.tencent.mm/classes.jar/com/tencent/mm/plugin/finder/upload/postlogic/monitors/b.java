package com.tencent.mm.plugin.finder.upload.postlogic.monitors;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.postlogic.base.g;
import com.tencent.mm.plugin.finder.upload.postlogic.base.k;
import com.tencent.mm.plugin.finder.upload.postlogic.finderstage.d;
import com.tencent.mm.plugin.finder.upload.postlogic.finderstage.f;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/monitors/StageFlowReportMonitor;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageMonitor;", "()V", "begin", "", "taskId", "", "beginStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "end", "endStage", "transfer", "from", "to", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements g
{
  public final void a(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame1, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame2)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(343283);
    s.u(paramString, "taskId");
    s.u(parame1, "from");
    s.u(parame2, "to");
    int j;
    label70:
    FinderItem localFinderItem;
    int i;
    if ((!(parame2 instanceof com.tencent.mm.plugin.finder.upload.postlogic.base.c)) && (!(parame2 instanceof k)))
    {
      j = 1;
      if (!(parame1 instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b)) {
        break label177;
      }
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      if (j == 0) {
        break label136;
      }
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOp();
      localFinderItem = ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b)parame1).Ged;
      if (j == 0) {
        break label147;
      }
      i = 0;
      label87:
      com.tencent.mm.plugin.finder.report.postreport.a.a(paramString, localFinderItem, 0, i);
    }
    for (;;)
    {
      if ((parame2 instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b))
      {
        paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
        paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
        com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOn(), ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b)parame2).Ged);
        AppMethodBeat.o(343283);
        return;
        j = 0;
        break;
        label136:
        paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
        paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOo();
        break label70;
        label147:
        parame1 = ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b)parame1).Ged.field_reportObject;
        if (parame1 == null)
        {
          i = 0;
          break label87;
        }
        i = parame1.mpError;
        break label87;
        label177:
        if ((parame1 instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.a))
        {
          paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
          if (j != 0)
          {
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOp();
            label201:
            localFinderItem = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.a)parame1).GeK;
            if (j == 0) {
              break label241;
            }
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.finder.report.postreport.a.a(paramString, localFinderItem, 0, i);
            break;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOo();
            break label201;
            label241:
            parame1 = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.a)parame1).GeK.field_reportObject;
            if (parame1 == null) {
              i = 0;
            } else {
              i = parame1.mpError;
            }
          }
        }
        if ((parame1 instanceof f))
        {
          paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
          if (j != 0)
          {
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOs();
            label295:
            localFinderItem = ((f)parame1).Ged;
            if (j == 0) {
              break label335;
            }
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.finder.report.postreport.a.a(paramString, localFinderItem, 0, i);
            break;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOr();
            break label295;
            label335:
            parame1 = ((f)parame1).Ged.field_reportObject;
            if (parame1 == null) {
              i = 0;
            } else {
              i = parame1.uploadLogicError;
            }
          }
        }
        if ((parame1 instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.e))
        {
          paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
          if (j != 0)
          {
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOs();
            label389:
            localFinderItem = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.e)parame1).Ged;
            if (j == 0) {
              break label429;
            }
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.finder.report.postreport.a.a(paramString, localFinderItem, 0, i);
            break;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOr();
            break label389;
            label429:
            parame1 = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.e)parame1).Ged.field_reportObject;
            if (parame1 == null) {
              i = 0;
            } else {
              i = parame1.uploadLogicError;
            }
          }
        }
        label483:
        label500:
        FinderFeedReportObject localFinderFeedReportObject;
        if ((parame1 instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c))
        {
          paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
          if (j != 0)
          {
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOv();
            localFinderItem = ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c)parame1).Ged;
            if (j == 0) {
              break label533;
            }
            i = 0;
            if (j == 0) {
              break label566;
            }
            j = k;
          }
          for (;;)
          {
            com.tencent.mm.plugin.finder.report.postreport.a.a(paramString, localFinderItem, i, j);
            break;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOu();
            break label483;
            label533:
            localFinderFeedReportObject = ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c)parame1).Ged.field_reportObject;
            if (localFinderFeedReportObject == null)
            {
              i = 0;
              break label500;
            }
            i = localFinderFeedReportObject.cgiErrorType;
            break label500;
            label566:
            parame1 = ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c)parame1).Ged.field_reportObject;
            j = k;
            if (parame1 != null) {
              j = parame1.cgiErrorCode;
            }
          }
        }
        if ((parame1 instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b))
        {
          paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
          if (j != 0)
          {
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOv();
            label618:
            localFinderItem = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b)parame1).Ged;
            if (j == 0) {
              break label668;
            }
            i = 0;
            label635:
            if (j == 0) {
              break label701;
            }
            j = m;
          }
          for (;;)
          {
            com.tencent.mm.plugin.finder.report.postreport.a.a(paramString, localFinderItem, i, j);
            break;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
            paramString = com.tencent.mm.plugin.finder.report.postreport.b.eOu();
            break label618;
            label668:
            localFinderFeedReportObject = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b)parame1).Ged.field_reportObject;
            if (localFinderFeedReportObject == null)
            {
              i = 0;
              break label635;
            }
            i = localFinderFeedReportObject.cgiErrorType;
            break label635;
            label701:
            parame1 = ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b)parame1).Ged.field_reportObject;
            j = m;
            if (parame1 != null) {
              j = parame1.cgiErrorCode;
            }
          }
        }
      }
    }
    if ((parame2 instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.a))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOn(), ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.a)parame2).GeK);
      AppMethodBeat.o(343283);
      return;
    }
    if ((parame2 instanceof f))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOq(), ((f)parame2).Ged);
      AppMethodBeat.o(343283);
      return;
    }
    if ((parame2 instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.e))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOq(), ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.e)parame2).Ged);
      AppMethodBeat.o(343283);
      return;
    }
    if ((parame2 instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOt(), ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c)parame2).Ged);
      AppMethodBeat.o(343283);
      return;
    }
    if ((parame2 instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOt(), ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b)parame2).Ged);
    }
    AppMethodBeat.o(343283);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343270);
    s.u(paramString, "taskId");
    s.u(parame, "beginStage");
    if ((parame instanceof d))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOl(), ((d)parame).Ged);
      AppMethodBeat.o(343270);
      return;
    }
    if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.mvstage.c))
    {
      paramString = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramString = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOl(), ((com.tencent.mm.plugin.finder.upload.postlogic.mvstage.c)parame).Ged);
    }
    AppMethodBeat.o(343270);
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343286);
    s.u(paramString, "taskId");
    s.u(parame, "endStage");
    AppMethodBeat.o(343286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.monitors.b
 * JD-Core Version:    0.7.0.1
 */