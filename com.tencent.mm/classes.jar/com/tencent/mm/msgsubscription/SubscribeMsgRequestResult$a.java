package com.tencent.mm.msgsubscription;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dfk;
import com.tencent.mm.protocal.protobuf.dfm;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "from", "response", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestResult$a
{
  public static SubscribeMsgRequestResult a(dfj paramdfj)
  {
    AppMethodBeat.i(179495);
    k.h(paramdfj, "response");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramdfj.thF;
    k.g(localObject1, "response.InfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dfh)((Iterator)localObject1).next();
      localObject3 = new ArrayList();
      localObject4 = ((dfh)localObject2).EfT;
      k.g(localObject4, "it.KeyWordList");
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (boh)((Iterator)localObject4).next();
        ((ArrayList)localObject3).add(new o(((boh)localObject5).Name, ((boh)localObject5).wTM));
      }
      k.g(localObject2, "it");
      localArrayList.add(new SubscribeMsgTmpItem((dfh)localObject2, (ArrayList)localObject3));
    }
    boolean bool1;
    if (paramdfj.FOM == 1)
    {
      bool1 = true;
      localObject1 = paramdfj.FOK;
      if (localObject1 != null) {
        break label894;
      }
      localObject1 = "";
    }
    label234:
    label628:
    label886:
    label894:
    for (;;)
    {
      localObject2 = paramdfj.FOJ;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        int j = paramdfj.FON;
        boolean bool2;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        boolean bool3;
        boolean bool4;
        int k;
        if (paramdfj.FOL == 1)
        {
          bool2 = true;
          localObject3 = paramdfj.FOI;
          if (localObject3 != null)
          {
            localObject4 = ((dfm)localObject3).ihe;
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = "";
          }
          localObject4 = paramdfj.FOI;
          if (localObject4 != null)
          {
            localObject5 = ((dfm)localObject4).ihf;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = paramdfj.FOI;
          if (localObject5 != null)
          {
            localObject6 = ((dfm)localObject5).ihg;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject6 = paramdfj.FOI;
          if (localObject6 != null)
          {
            localObject7 = ((dfm)localObject6).ihh;
            localObject6 = localObject7;
            if (localObject7 != null) {}
          }
          else
          {
            localObject6 = "";
          }
          localObject7 = paramdfj.FOI;
          if (localObject7 != null)
          {
            localObject8 = ((dfm)localObject7).ihi;
            localObject7 = localObject8;
            if (localObject8 != null) {}
          }
          else
          {
            localObject7 = "";
          }
          localObject8 = paramdfj.FOI;
          if (localObject8 != null)
          {
            localObject9 = ((dfm)localObject8).ihj;
            localObject8 = localObject9;
            if (localObject9 != null) {}
          }
          else
          {
            localObject8 = "";
          }
          localObject9 = paramdfj.FOI;
          if (localObject9 != null)
          {
            localObject10 = ((dfm)localObject9).ihk;
            localObject9 = localObject10;
            if (localObject10 != null) {}
          }
          else
          {
            localObject9 = "";
          }
          Object localObject10 = paramdfj.FOI;
          if (localObject10 != null)
          {
            localObject11 = ((dfm)localObject10).ihl;
            localObject10 = localObject11;
            if (localObject11 != null) {}
          }
          else
          {
            localObject10 = "";
          }
          Object localObject11 = paramdfj.FOI;
          if (localObject11 != null)
          {
            localObject12 = ((dfm)localObject11).ihm;
            localObject11 = localObject12;
            if (localObject12 != null) {}
          }
          else
          {
            localObject11 = "";
          }
          Object localObject12 = paramdfj.FOI;
          if (localObject12 != null)
          {
            localObject13 = ((dfm)localObject12).ihn;
            localObject12 = localObject13;
            if (localObject13 != null) {}
          }
          else
          {
            localObject12 = "";
          }
          Object localObject13 = paramdfj.FOI;
          if (localObject13 != null)
          {
            String str = ((dfm)localObject13).iho;
            localObject13 = str;
            if (str != null) {}
          }
          else
          {
            localObject13 = "";
          }
          localObject8 = new WordingInfo((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
          if (paramdfj.FOA != 1) {
            break label866;
          }
          bool3 = true;
          if (paramdfj.FOR != 1) {
            break label872;
          }
          bool4 = true;
          localObject3 = paramdfj.Buffer;
          if (localObject3 == null) {
            break label878;
          }
          localObject3 = ((b)localObject3).toByteArray();
          k = paramdfj.FOX;
          localObject4 = paramdfj.FOY;
          if (localObject4 == null) {
            break label886;
          }
        }
        for (int i = ((dfk)localObject4).FeA;; i = -1)
        {
          localObject4 = paramdfj.FOY;
          if (localObject4 != null)
          {
            localObject5 = ((dfk)localObject4).EVJ;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = paramdfj.FOY;
          if (localObject5 != null)
          {
            localObject6 = ((dfk)localObject5).FOZ;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject9 = new ShowInfo(i, (String)localObject4, (String)localObject5);
          localObject5 = paramdfj.FOV;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          localObject6 = paramdfj.FOW;
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = "";
          }
          i = paramdfj.FOS;
          localObject7 = paramdfj.FOT;
          localObject6 = localObject7;
          if (localObject7 == null) {
            localObject6 = "";
          }
          paramdfj = new SubscribeMsgRequestResult(bool1, (String)localObject1, (String)localObject2, j, localArrayList, bool2, (WordingInfo)localObject8, bool3, bool4, (byte[])localObject3, k, (ShowInfo)localObject9, (String)localObject4, (String)localObject5, i, (String)localObject6, paramdfj.FOU);
          AppMethodBeat.o(179495);
          return paramdfj;
          bool1 = false;
          break;
          bool2 = false;
          break label234;
          bool3 = false;
          break label617;
          bool4 = false;
          break label628;
          localObject3 = new byte[0];
          break label646;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.SubscribeMsgRequestResult.a
 * JD-Core Version:    0.7.0.1
 */