package com.tencent.mm.plugin.finder.report;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.bqs;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
public abstract interface p$a
{
  public abstract void a(long paramLong, bqs parambqs, String paramString, int paramInt, LinkedList<bqs> paramLinkedList, BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p.a
 * JD-Core Version:    0.7.0.1
 */