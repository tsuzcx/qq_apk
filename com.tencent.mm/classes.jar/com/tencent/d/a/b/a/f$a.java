package com.tencent.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/NearbyConstants$EMFinderLiveActivityType;", "", "Companion", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f$a
{
  public static final a ahpZ = a.ahqa;
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/NearbyConstants$EMFinderLiveActivityType$Companion;", "", "()V", "MMFinderLiveActivityType_JoinGameTeam", "", "MMFinderLiveActivityType_Lottery", "MMFinderLiveActivityType_Mic", "MMFinderLiveActivityType_PK", "MMFinderLiveActivityType_RedPacket", "getImageResFromActivityType", "actType", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(216488);
      ahqa = new a();
      AppMethodBeat.o(216488);
    }
    
    public static int getImageResFromActivityType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 1: 
        return g.a.finder_act_type_icon_1;
      case 2: 
        return g.a.finder_act_type_icon_2;
      case 3: 
        return g.a.finder_act_type_icon_3;
      case 4: 
        return g.a.finder_act_type_icon_4;
      }
      return g.a.finder_act_type_icon_5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.b.a.f.a
 * JD-Core Version:    0.7.0.1
 */