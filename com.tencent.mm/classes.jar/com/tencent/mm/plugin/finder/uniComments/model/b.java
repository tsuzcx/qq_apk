package com.tencent.mm.plugin.finder.uniComments.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.boo;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "", "app_name", "", "entity_id", "(Ljava/lang/String;Ljava/lang/String;)V", "getApp_name", "()Ljava/lang/String;", "setApp_name", "(Ljava/lang/String;)V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "getEntity_id", "setEntity_id", "field_id", "", "getField_id", "()J", "setField_id", "(J)V", "field_username", "getField_username", "setField_username", "finderMVSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getFinderMVSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setFinderMVSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "id", "getId", "setId", "isCommentClose", "", "()Z", "setCommentClose", "(Z)V", "nickName", "getNickName", "setNickName", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "oldVersion", "getOldVersion", "setOldVersion", "userName", "getUserName", "setUserName", "isCommentClose1", "isOldVersion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public boolean AHL;
  public String GaE;
  public boo Gbe;
  public int commentCount;
  private LinkedList<FinderCommentInfo> commentList;
  public long field_id;
  public String field_username;
  public int id;
  public String nickName;
  public String objectNonceId;
  public String userName;
  public String xlJ;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(341730);
    this.xlJ = paramString1;
    this.GaE = paramString2;
    this.nickName = "";
    this.userName = "";
    this.id = s.X(this.xlJ, this.GaE).hashCode();
    this.field_id = s.X(this.xlJ, this.GaE).hashCode();
    this.objectNonceId = "";
    this.field_username = "";
    this.commentList = new LinkedList();
    AppMethodBeat.o(341730);
  }
  
  public static boolean fdK()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.model.b
 * JD-Core Version:    0.7.0.1
 */